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
) extends InjectedController with Logging {
  // @see https://scalacourses.com/student/showLecture/129

  def help: Action[AnyContent] = Action { implicit request =>
    Ok(views.html.welcome("Play Help"))
  }

  def hello(name: String): Action[AnyContent] = Action { implicit request =>
    Ok(views.html.hello(if (name.isEmpty) "Everybody" else name))
  }
}
