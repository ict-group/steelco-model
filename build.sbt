organization := "it.ictgroup"
name := "steelcomodel"
version := "0.2.6"
scalaVersion := "2.13.1"

githubOwner := "ict-group"
githubRepository := "steelco-model"

val microstreamVersion = "03.00.00-MS-GA"

libraryDependencies += "one.microstream"     % "storage.embedded"               % microstreamVersion
libraryDependencies += "one.microstream"     % "storage.embedded.configuration" % microstreamVersion

resolvers += "microstream-releases" at "https://repo.microstream.one/repository/maven-public/"