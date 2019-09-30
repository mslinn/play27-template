package controllers

import javax.inject._
import org.webjars.play.WebJarsUtil
//import akka.stream.Materializer
import play.api._
//import play.api.cache.{CacheApi, Cached}
//import play.api.db.slick.DatabaseConfigProvider
import play.api.i18n.MessagesApi
//import play.api.libs.ws.WSClient
import play.api.mvc._
//import play.libs.mailer.MailerClient
//import scala.concurrent.ExecutionContext

/** The [[https://scalacourses.com/student/showLecture/14 Play 2 Controllers]] lecture discusses this class.
  * The [[https://scalacourses.com/student/showLecture/249 Using Google Guice for Dependency Injection]] lecture
  * discusses each of the injected parameters. */
@Singleton
class ApplicationController @Inject() ( // order of these explicit parameters does not matter
//  cached: Cached,
//  cache: CacheApi,
//  config: Configuration,
//  db: DatabaseConfigProvider,
//  mailer: MailerClient,
    override val messagesApi: MessagesApi // this parameter must be a property
//  ws: WSClient
)(implicit   // order of these implicit parameters does not matter
  assets: AssetsFinder,
//  ex: ExecutionContext,
//  mat: Materializer,
//  env: Environment,
  webJarsUtil: WebJarsUtil
) extends InjectedController {
  // @see https://scalacourses.com/student/showLecture/129
  val Logger: org.slf4j.Logger = org.slf4j.LoggerFactory.getLogger("application")

  def help = Action { implicit request =>
    Ok(views.html.welcome("Play Help"))
  }

  def hello(name: String) = Action { implicit request =>
    Ok(views.html.hello(if (name.isEmpty) "Everybody" else name))
  }
}
