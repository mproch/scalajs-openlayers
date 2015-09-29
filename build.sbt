enablePlugins(ScalaJSPlugin)

organization  := "pl.mproch"
name := "scalaJS-OpenLayers"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % "0.8.0"
)

