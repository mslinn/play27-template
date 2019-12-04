/* The person who associated a work with this deed has dedicated the work to the public domain by waiving all of his or
 * her rights to the work worldwide under copyright law, including all related and neighboring rights, to the extent allowed by law.
 *
 * You can copy, modify, distribute and perform the work, even for commercial purposes, all without asking permission.
 *
 * In no way are the patent or trademark rights of any person affected by CC0, nor are the rights that other persons may
 * have in the work or in how the work is used, such as publicity or privacy rights.
 * Unless expressly stated otherwise, the person who associated a work with this deed makes no warranties about the work,
 * and disclaims liability for all uses of the work, to the fullest extent permitted by applicable law.
 * When using or citing the work, you should not imply endorsement by the author or the affirmer.
 *
 * The full legal text is here: https://creativecommons.org/publicdomain/zero/1.0/legalcode */

// See the [https://scalacourses.com/student/showLecture/84](SBT Global Setup),
// [https://scalacourses.com/student/showLecture/135](SBT Project Setup) and
// [https://scalacourses.com/student/showLecture/169](Standard Files and Directories and Improved Template) lectures

import sbt._
import sbt.Keys._
import Settings._

developers := List(  // TODO put your information here
  Developer(gitHubId,  // defined in project/Settings.scala
            "Mike Slinn",
            "mslinn@micronauticsresearch.com",
            url(s"https://github.com/$gitHubId")
  )
)

fork in Test := true   // disable this if you want IntelliJ IDEA to honor breakpoints when tests are launched via SBT tasks

herokuAppName in Compile := "play27-template" // TODO change "play27-template" to a project name that you like

// define the statements initially evaluated when entering 'console', 'console-quick', or 'console-project'
initialCommands := """import scala.language.postfixOps
                     |import java.net.URL
                     |import java.text.DateFormat
                     |import java.util.Locale
                     |import play.api._
                     |import play.api.db.DB
                     |import play.api.i18n._
                     |import play.api.libs.json._
                     |import play.api.Play.current
                     |import play.Logger
                     |import scala.reflect.runtime.universe._
                     |import views.html.helper._
                     |""".stripMargin

javacOptions ++= Seq(
  "-Xlint:deprecation",
  "-Xlint:unchecked",
  "-source", "1.8",
  "-target", "1.8",
  "-g:vars"
)

javaOptions in Test += "-Dconfig.file=conf/dev.conf"

libraryDependencies ++= Seq( // TODO (un)comment dependencies that your project requires
//  anorm,
//  cache,
//  evolutions,
//  filters,
  guice,
//  jdbc,
//  json,
//  ws,
//  "com.typesafe.play"         %% "play-mailer"        % "6.0.1" withSources(),
//  "com.typesafe.play"         %% "play-mailer-guice" % "6.0.1" withSources(),
  "com.typesafe.akka"         %% "akka-slf4j"         % "2.5.23",
  "net.codingwell"            %% "scala-guice"        % "4.2.6",
  "org.webjars"               %% "webjars-play"       % "2.7.3",
  "org.webjars"               %  "bootstrap"          % "4.3.1",
//  "com.github.tototoshi"      %% "slick-joda-mapper"  % "2.4.1" withSources(),
  "com.typesafe"              %  "config"             % "1.3.4" withSources(),
//  "com.typesafe.slick"        %% "slick"              % "3.3.2" withSources(),
  "com.github.vital-software" %% "json-annotation"      % "0.6.2"  withSources(),
  "com.typesafe.play"         %% "play-json"            % "2.8.0"  withSources(),
  "com.typesafe.play"         %% "play-json-joda"       % "2.8.0"  withSources(),
//  "com.typesafe.play"         %% "play-slick"         % "4.0.2" withSources(),
//  "org.postgresql"            % "postgresql"          % "42.2.8" withSources(),
  "org.webjars"               %  "jquery-ui"          % "1.12.1",
  "org.webjars"               %  "jquery-ui-themes"   % "1.12.1",
  //
  "org.scalatestplus.play"    %% "scalatestplus-play" % "4.0.3" % Test,
  "junit"                     %  "junit"              % "4.12"  % Test
)

licenses += ("CC0", url("https://creativecommons.org/publicdomain/zero/1.0/"))

logBuffered in Test := false
logLevel := Level.Warn
logLevel in compile := Level.Warn
logLevel in test := Level.Info // Level.Info is needed to see detailed output when running tests

name         := "play27-template" // TODO change "play27-template" to a project name that you like

organization := "com.micronautics"

parallelExecution in Test := false

resolvers ++= Seq(
  "webjars" at "https://webjars.github.com/m2",
  //Resolver.file("Local Repository", file(sys.env.get("PLAY_HOME").map(_ + "/repository/local").getOrElse("")))(Resolver.ivyStylePatterns),
  Resolver.url("play-plugin-releases", new URL("https://repo.scala-sbt.org/scalasbt/sbt-plugin-releases/"))(Resolver.ivyStylePatterns)
)

scalacOptions ++= Seq(
  "-deprecation",
  "-encoding", "UTF-8",
  "-feature",
  "-target:jvm-1.8",
  "-unchecked"
)

Global / onChangedBuildSource := ReloadOnSourceChanges

scalaVersion := "2.13.1"

scmInfo := Some(
  ScmInfo(
    url(s"https://github.com/$gitHubId/$name"),
    s"git@github.com:$gitHubId/$name.git"
  )
)

version := "2.7.3.3"

lazy val root = (project in file(".")).enablePlugins(PlayScala)
enablePlugins(ApiMappings)
