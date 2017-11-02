package uk.co.testcraft.tests

import org.scalatest.selenium.WebBrowser
import uk.co.testcraft.pages.{GovUkPage, TimetablePage, TrainlineHomepage, WebPage}
import uk.co.testcraft.tags.SmokeTest

class TrainlineSpec extends BaseFeatureSpec with WebBrowser with WebPage {

  feature("Trainline Plan Journey") {

    scenario("Scenario 1", SmokeTest) {

      When("I navigate to the Trainline homepage")
      TrainlineHomepage.goToPage()
      pageTitle should include ("Trainline")

      When("I enter in two stations")
      TrainlineHomepage.inputStations

      And("click submit")
      TrainlineHomepage.submitSearch

      Then("the Timetable page should be visible")
      TimetablePage.timetableDisplay.findElement shouldBe defined



    }
  }
}
