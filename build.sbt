lazy val root =
  Project("pom2sbt", file("."))

lazy val core =
  module("core")
    .settings(description := "Tools for reading a Maven POM")
