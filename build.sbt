organization := "it.ictgroup"
name := "steelcomodel"
version := "0.1.0"
scalaVersion := "2.12.10"

githubOwner := "ict-group"
githubRepository := "steelco-model"

val microstreamVersion = "02.02.00-MS-GA"

libraryDependencies += "one.microstream"     % "storage.embedded"               % microstreamVersion
libraryDependencies += "one.microstream"     % "storage.embedded.configuration" % microstreamVersion

resolvers += "microstream-releases" at "https://repo.microstream.one/repository/maven-public/"