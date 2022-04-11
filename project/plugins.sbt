resolvers += MavenRepository("HMRC-open-artefacts-maven2", "https://open.artefacts.tax.service.gov.uk/maven2")
resolvers += Resolver.url("HMRC-open-artefacts-ivy2", url("https://open.artefacts.tax.service.gov.uk/ivy2"))(
  Resolver.ivyStylePatterns
)

addSbtPlugin("uk.gov.hmrc" % "sbt-auto-build" % "3.5.0")
addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.8.15")
addSbtPlugin("org.foundweekends.giter8" % "sbt-giter8-scaffold" % "0.13.1")
