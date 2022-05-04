/*
 * Copyright 2022 HM Revenue & Customs
 *
 */

package filters

import javax.inject.Inject
import akka.stream.Materializer
import play.api.mvc._

import scala.concurrent.ExecutionContext
import scala.concurrent.Future

class PreventUpdatingSessionFilter @Inject() (implicit val mat: Materializer, ec: ExecutionContext) extends Filter {
  def apply(nextFilter: RequestHeader => Future[Result])(requestHeader: RequestHeader): Future[Result] =
    nextFilter(requestHeader).map { result =>
      import play.api.routing.Router.RequestImplicits._
      if (requestHeader.hasRouteModifier("prevent-updating-session")) {
        // because another filter encrypts session data into a cookie, we clear the newCookies from the result rather
        // than the newSession (where data is first set). Play itself triggers the "baking" of cookie/session/flash data
        // into the response when it's send so we can't just discard the Set-Cookie header in a filter.
        result.copy(newCookies = Seq.empty)
      } else {
        result
      }
    }
}
