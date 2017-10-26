name := "scalatest-template"

version := "0.1"

scalaVersion := "2.12.2"

val SeleniumVersion = "3.4.0"
val ScalatestVersion = "3.0.1"

credentials += Credentials(Path.userHome / ".sbt" / ".credentials")

scalacOptions ++= Seq("-unchecked", "-deprecation")

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % ScalatestVersion % "test",
  "org.seleniumhq.selenium" % "selenium-java" % SeleniumVersion % "test",
  "org.typelevel" %% "cats" % "0.9.0",
  "org.pegdown" % "pegdown" % "1.6.0" % "test"
)

testOptions in Test += Tests.Argument(TestFrameworks.ScalaTest, "-h", "target/test-reports/html-report")