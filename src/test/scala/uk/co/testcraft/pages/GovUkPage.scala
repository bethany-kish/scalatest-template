package uk.co.testcraft.pages

object GovUkPage extends WebPage {

  override val url : String = "http://www.gov.uk"

  def pageHeader: Query = cssSelector("h1")

}
