val scala3Version = "3.6.4"

lazy val root = project
  .in(file("."))
  .settings(
    name := "hello-world",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,

    libraryDependencies += "org.scalameta" %% "munit" % "1.0.0" % Test
  )

ThisBuild / develocityConfiguration ~= { previous =>
  previous
    .withServer(
      previous.server
        .withUrl(url("https://ge.solutions-team.gradle.com"))
    )
}

ThisBuild / develocityConfiguration ~= { previous =>
  previous
    .withBuildScan(
      previous.buildScan
        .withBackgroundUpload(false)
    )
    .withBuildCache(
      previous.buildCache
        .withLocal(previous.buildCache.local.withEnabled(true))
        .withRemote(previous.buildCache.remote.withStoreEnabled(false))
    )
}