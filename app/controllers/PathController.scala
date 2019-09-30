package controllers

import javax.inject.{Inject, Provider}
import org.webjars.play.WebJarsUtil
import play.api.i18n.I18nSupport
import play.api.mvc.{MessagesAbstractController, MessagesControllerComponents}
import play.api.routing.Router
import play.twirl.api.Html
import views.html.mainBootstrap

class PathController @Inject()(
  mcc: MessagesControllerComponents,
  routesProvider: Provider[Router]
)(implicit   // order of these implicit parameters does not matter
  assets: AssetsFinder,
  webJarsUtil: WebJarsUtil
) extends MessagesAbstractController(mcc) with I18nSupport {
  lazy val routeDocs: Seq[(String, String, String)] = routesProvider.get.documentation
  val className: String = getClass.getName

  def index = Action { implicit request =>
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
