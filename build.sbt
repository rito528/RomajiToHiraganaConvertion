ThisBuild / name := "RomajiToHiraganaConversion"

ThisBuild / version := "1.0.2"

ThisBuild / scalaVersion := "2.13.8"

ThisBuild / versionScheme := Some("early-semver")

publishTo := Some(Resolver.file("RomajiToHiraganaConversion",file("jar,work/"))(Patterns(true, Resolver.mavenStyleBasePattern)))