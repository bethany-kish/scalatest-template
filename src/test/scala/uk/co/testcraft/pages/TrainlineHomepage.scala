package uk.co.testcraft.pages

import uk.co.testcraft.pages.GovUkPage.cssSelector

object TrainlineHomepage extends WebPage{

  override val url : String = "https://www.thetrainline.com/"

  def pageTitle: Query = cssSelector("h1")


  def inputStations: Unit = {
    searchField("originStation").value = "Brighton"
    searchField("destinationStation").value = "London"
  }

  def submitSearch: Unit = {
    click on cssSelector(".is-alone")
    click on "submitButton"

  }


}
