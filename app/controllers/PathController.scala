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

package controllers

import javax.inject.{Inject, Provider}
import org.webjars.play.WebJarsUtil
import play.api.Logging
import play.api.i18n.I18nSupport
import play.api.mvc.{Action, AnyContent, MessagesAbstractController, MessagesControllerComponents}
import play.api.routing.Router
import play.twirl.api.Html
import views.html.mainBootstrap

class PathController @Inject()( // order of these explicit parameters does not matter
  mcc: MessagesControllerComponents,
  routesProvider: Provider[Router]
)(implicit   // order of these implicit parameters does not matter
  assets: AssetsFinder,
  webJarsUtil: WebJarsUtil
) extends MessagesAbstractController(mcc) with I18nSupport with Logging {
  lazy val routeDocs: Seq[(String, String, String)] = routesProvider.get.documentation
  val className: String = getClass.getName

  def index: Action[AnyContent] = Action { implicit request =>
    val thisMethod: String = className + "." + getClass.getMethod("index").getName

    val info: String = routeDocs.map { case (method, path, controllerMethod) =>
      val marker = if (thisMethod==controllerMethod) "<b>This route serviced the request for the page you are looking at:</b>\n" else ""
      s"""${marker}method: $method
         |path: $path
         |controllerMethod: $controllerMethod
         |""".stripMargin
    }.mkString("<pre>", "\n", "</pre>")
    Ok(mainBootstrap("Webapp Routes")(Html(info)))
  }
}
