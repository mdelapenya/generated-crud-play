name := """generatedcrud"""

version := "1.0-SNAPSHOT"

resolvers += "mvnrepository" at "http://mvnrepository.com/artifact/"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  evolutions,
  javaWs,
  "com.adrianhurt" %% "play-bootstrap" % "1.6.1-P26-B3",
  "commons-io" % "commons-io" % "2.4",
  "org.easytesting" % "fest-assert" % "1.4" % Test,
  "org.freemarker" % "freemarker" % "2.3.21"
)