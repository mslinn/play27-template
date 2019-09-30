package views.html

/** See the [[https://scalacourses.com/student/showLecture/15 Twirl View Templates]] lecture. */
import controllers.AssetsFinder
import org.webjars.play.WebJarsUtil
import play.api.mvc.RequestHeader
import play.twirl.api.Html

object hello {
  def apply(name: String)
           (implicit assetsFinder: AssetsFinder, request: RequestHeader, webJarsUtil: WebJarsUtil): Html = {
    val urlStr = "https://courseassets.scalacourses.com/1/html/ScalaCore/assets"
    val url = assetsFinder.withUrlPrefix(urlStr).path("images/getscala.com2.gif")
    val info: String =
      s"""<p>It's so good to see you, $name!</p>
         |
         |<h2>Fun With <span class='code'>AssetFinder</span></h2>
         |<p>An automatically created <code>AssetsFinder</code> for the <code>root</code> SBT module was injected into the controller handling this request.</p>
         |<pre><b>assetsFinder.assetsBasePath</b> = ${ assetsFinder.assetsBasePath }
         |<b>assetsFinder.assetsUrlPrefix</b> = ${ assetsFinder.assetsUrlPrefix }
         |<b>assetsFinder.path("x")</b> = ${ assetsFinder.path("x") }
         |
         |// The first argument (<code>base</code>) must start with a slash and must not end with a slash, and must be the prefix of the second argument:
         |<b>assetsFinder.findAssetPath("/assets", "/assets/asdf.png")</b> = ${ assetsFinder.findAssetPath("/assets", "/assets/asdf.png") }
         |</pre>
         |
         |<p>All of the following methods return another <code>AssetFinder</code>, which I apply <code>.path("x")</code> to:</p>
         |<pre><b>assetsFinder.unprefixed.path("x")</b> = ${ assetsFinder.unprefixed.path("x") }
         |<b>assetsFinder.withAssetsPath("/asdf").path("x")</b> = ${ assetsFinder.withAssetsPath("/asdf").path("x") }    // withAssetsPath seems broken
         |</pre>
         |
         |<p>Various types of URLs are handled. URL prefixes must not end with a trailing slash:</p>
         |<pre>
         |<b>assetsFinder.withUrlPrefix("/asdf").path("x")</b> = ${ assetsFinder.withUrlPrefix("/asdf").path("x") }
         |
         |<b>val url = "$urlStr"
         |assetsFinder.withUrlPrefix(url).path("images/getscala.com2.gif")</b> =
         |  <a href='$url'>$url</a>
         |</pre>
         |""".stripMargin
    mainBootstrap(s"Hello, $name!")(Html(info))
  }
}
