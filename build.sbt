name := """platui-1619"""
organization := "uk.gov.hmrc"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.8"

resolvers += MavenRepository("HMRC-open-artefacts-maven2", "https://open.artefacts.tax.service.gov.uk/maven2")
resolvers += Resolver.url("HMRC-open-artefacts-ivy2", url("https://open.artefacts.tax.service.gov.uk/ivy2"))(
  Resolver.ivyStylePatterns
)

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test
libraryDependencies += "uk.gov.hmrc"              %% "bootstrap-frontend-play-28" % "5.14.0"
libraryDependencies += "uk.gov.hmrc"              %% "play-frontend-hmrc" % "3.13.0-play-28"


// Adds additional packages into Twirl
//TwirlKeys.templateImports += "uk.gov.hmrc.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "uk.gov.hmrc.binders._"
