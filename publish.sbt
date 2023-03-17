ThisBuild / organization := "io.github.substate-tech"
ThisBuild / organizationName := "substate-tech"
ThisBuild / organizationHomepage := Some(url("https://substate-tech.github.io"))

ThisBuild / scmInfo := Some(
  ScmInfo(
    url("https://github.com/substate-tech/baster"),
    "scm:git@github.com:substate-tech/baster.git"
  )
)

ThisBuild / developers := List(
  Developer(
    id    = "richmorj",
    name  = "Richard James Richmond",
    email = "richmorj@fastmail.fm",
    url   = url("https://substate-tech.github.io")
  )
)

ThisBuild / description := "Base Unit Tester (extends ChiselTest)"
ThisBuild / licenses := List("Apache License, Version 2.0" -> new URL("https://www.apache.org/licenses/LICENSE-2.0.html"))
ThisBuild / homepage := Some(url("https://github.com/substate-tech/baster"))

// Remove all additional repository other than Maven Central from POM
ThisBuild / pomIncludeRepository := { _ => false }

ThisBuild / publishTo := {
  val nexus = "https://s01.oss.sonatype.org/"
  if (isSnapshot.value) Some("snapshots" at nexus + "content/repositories/snapshots")
  else Some("releases" at nexus + "service/local/staging/deploy/maven2")
}

ThisBuild / publishMavenStyle := true

ThisBuild / versionScheme := Some("early-semver")
