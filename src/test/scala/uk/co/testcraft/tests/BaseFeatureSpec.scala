package uk.co.testcraft.tests

import java.util.concurrent.TimeUnit

import cats.syntax.either._
import org.openqa.selenium.WebDriver
import org.scalatest._
import uk.co.testcraft.utils.Driver

trait BaseFeatureSpec extends FeatureSpec with BeforeAndAfterAll with GivenWhenThen with Matchers with BeforeAndAfter {

  import BaseFeatureSpec._

  /** Tries to get the value of [[_driver]] - will throw an exception if it doesn't exist */
  implicit def getDriverUnsafe: WebDriver = _driver.getOrElse(sys.error("Driver does not exist"))

  // create a new driver for each scenario
  before {
    if(_driver.isEmpty) {
      val d = Driver.newWebDriver()
        // map the left to Nothing
        .leftMap(e ⇒ sys.error(s"Could not find driver: $e"))
        // merge will merge Nothing and WebDriver to WebDriver since Nothing is a subtype of everything
        .merge
      d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
      _driver = Some(d)
    }
  }

  after {
    _driver.foreach(_.quit())
    _driver = None
  }

}


/**
  * Each test spec file extends the `BaseFeatureSpec` trait , but they will all reference this single driver
  * in the companion object. Having this variable in the trait would cause multiple drivers to be
  * created
  */
object BaseFeatureSpec {
  private var _driver: Option[WebDriver] = None
}