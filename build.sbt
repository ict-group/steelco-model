organization := "it.ictgroup"
name := "steelcomodel"
version := "0.6.5"
scalaVersion := "2.13.1"

githubOwner := "ict-group"
githubRepository := "steelco-model"

val microstreamVersion = "06.01.00-MS-GA"

libraryDependencies += "one.microstream"     % "microstream-storage-embedded"               % microstreamVersion
libraryDependencies += "one.microstream"     % "microstream-storage-embedded-configuration" % microstreamVersion