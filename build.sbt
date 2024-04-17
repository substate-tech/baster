// See README.md for license details.

//coverageEnabled := true
//logBuffered in Test := false

ThisBuild / scalaVersion     := "2.13.12"
ThisBuild / version          := "0.1.0"
ThisBuild / organization     := "io.github.substate-tech"

// Library dependencies
val chiselVersion = "6.0.0"
val chiseltestVersion = "6.0.0"
val scalatestVersion = "3.2.16"

lazy val root = (project in file("."))
  .settings(
    name := "baster",
    libraryDependencies ++= Seq(
      "org.chipsalliance" %% "chisel" % chiselVersion,
      "edu.berkeley.cs" %% "chiseltest" % chiseltestVersion,
      "org.scalatest" %% "scalatest" % scalatestVersion,
      "org.scala-lang" % "scala-reflect" % scalaVersion.value
    ),
    scalacOptions ++= Seq(
      "-Xsource:2.13",
      "-language:reflectiveCalls",
      "-deprecation",
      "-feature",
      "-Xcheckinit",
      // do not warn about firrtl imports, once the firrtl repo is removed, we will need to import the code
      "-Wconf:cat=deprecation&msg=Importing from firrtl is deprecated:s",
      // do not warn about firrtl deprecations
      "-Wconf:cat=deprecation&msg=will not be supported as part of the migration to the MLIR-based FIRRTL Compiler:s"
    ),
    addCompilerPlugin("org.chipsalliance" % "chisel-plugin" % chiselVersion cross CrossVersion.full)
  )

enablePlugins(SiteScaladocPlugin)
publishSite

enablePlugins(GhpagesPlugin)
git.remoteRepo := "git@github.com:substate-tech/baster.git"
