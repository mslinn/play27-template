import play.api.test._
import play.api.test.Helpers._
import org.scalatest._
import org.scalatestplus.play.{OneAppPerSuite, PlaySpec}
import play.test.WithApplication

/** See these lectures:<br>
  * &bull; [[https://scalacourses.com/student/showLecture/75 Unit testing With ScalaTest and Specs2]] <br>
  * &bull; [[https://scalacourses.com/student/showLecture/20 Testing Play for Scala Applications]] <br>
  * &bull; [[https://scalacourses.com/student/showLecture/252 Mitigating the Impact of Play's API Churn on Tests]] <br>
  * &bull; [[https://scalacourses.com/student/showLecture/251 Example Play for Scala Tests]] */
class ApplicationSpec extends PlaySpec with OneAppPerSuite {
  "ApplicationController" should {
    "send 404 on a bad request" ignore { // all routes are valid
      route(app, FakeRequest(GET, "/boom")) foreach { result =>
        status(result) mustEqual NOT_FOUND
      }
    }

    "render the index page" in {
      route(app, FakeRequest(GET, "/")) foreach { result =>
        status(result) mustEqual OK
        contentType(result).value mustEqual "text/html"
        contentAsString(result) must include("It's so good to see you, Everybody!")
      }
    }
  }
}
