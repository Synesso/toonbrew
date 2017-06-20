enablePlugins(ScalaJSPlugin, ScalaJSBundlerPlugin)

name := "Toon Brew"

scalaVersion := "2.12.2"

scalaJSUseMainModuleInitializer := true

libraryDependencies += "be.doeraene" %%% "scalajs-jquery" % "0.9.1"

skip in packageJSDependencies := false

jsDependencies += "org.webjars" % "jquery" % "2.1.4" / "2.1.4/jquery.js"

npmDependencies in Compile += "fantasy-names" -> "1.1.2"
