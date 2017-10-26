package uk.co.testcraft.tests

import org.scalatest.selenium.WebBrowser
import uk.co.testcraft.pages.{GovUkPage, WebPage}

class GovUkSpec extends BaseFeatureSpec with WebBrowser with WebPage {

  feature("Gov UK main page") {

    scenario("Navigate to the gov.uk homepage") {

      When("I navigate to the gov.uk homepage")
      GovUkPage.goToPage()

      Then("the gov.uk page should be loaded")
      GovUkPage.pageHeader.element.text shouldBe "Welcome to GOV.UK"
    }

  }


}
