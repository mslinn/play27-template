package views.html

import controllers.AssetsFinder
import controllers.routes.{ApplicationController => AppRoutes}
import controllers.routes.{PathController => PathRoutes}
import play.api.mvc.{Call, RequestHeader}
import play.twirl.api.Html

/** See the [[https://scalacourses.com/student/showLecture/215 Plain Old Scala View Templates]] lecture. */
object menu {
  protected[html] def listItem(call: Call, linkText: String)
                              (implicit request: RequestHeader): String = {
    val uri = call.toString
    if (uri==request.uri) s"""<li class="active"><a href="#">$linkText</a></li>""" else s"""<li><a href="$uri">$linkText</a></li>"""
  }

  def apply()(implicit assets: AssetsFinder, request: RequestHeader): Html =
    Html(s"""<nav class="navbar navbar-default navbar-inverse navbar-static-top" role="navigation">
            |  <ul class="nav navbar-nav">
            |    ${ listItem(AppRoutes.hello("Everybody"), "Welcome") }
            |    ${ listItem(AppRoutes.help(), "Help") }
            |    ${ listItem(PathRoutes.index, "Routes") }
            |  </ul>
            |  <ul class="nav navbar-nav navbar-right">
            |    ${ listItem(Call("GET", "https://github.com/mslinn/play26-template"), "GitHub")}
            |  </ul>
            |  <ul class="nav navbar-nav">
            |  </ul>
            |</nav>""".stripMargin)
}
