name := "ScalaLab"

version := "0.1"

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  "org.scalanlp" % "breeze-viz_2.10" % "0.5.1",
  "org.scalanlp" % "breeze_2.10" % "0.9",
  "org.scalanlp" % "breeze-natives_2.10" % "0.9"
)

resolvers += "Sonatype Releases" at "https://oss.sonatype.org/content/repositories/releases/"