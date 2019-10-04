/* The person who associated a work with this deed has dedicated the work to the public domain by waiving all of his or
 * her rights to the work worldwide under copyright law, including all related and neighboring rights, to the extent allowed by law.
 *
 * You can copy, modify, distribute and perform the work, even for commercial purposes, all without asking permission.
 *
 * In no way are the patent or trademark rights of any person affected by CC0, nor are the rights that other persons may
 * have in the work or in how the work is used, such as publicity or privacy rights.
 * Unless expressly stated otherwise, the person who associated a work with this deed makes no warranties about the work,
 * and disclaims liability for all uses of the work, to the fullest extent permitted by applicable law.
 * When using or citing the work, you should not imply endorsement by the author or the affirmer.
 *
 * The full legal text is here: https://creativecommons.org/publicdomain/zero/1.0/legalcode */

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
            |    ${ listItem(Call("GET", "https://github.com/mslinn/play27-template"), "GitHub")}
            |  </ul>
            |  <ul class="nav navbar-nav">
            |  </ul>
            |</nav>""".stripMargin)
}
