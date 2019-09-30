// See the [https://scalacourses.com/student/showLecture/84](SBT Global Setup),
// [https://scalacourses.com/student/showLecture/135](SBT Project Setup) and
// [https://scalacourses.com/student/showLecture/169](Standard Files and Directories and Improved Template) lectures

import sbt._
import sbt.Keys._

developers := List(  // TODO put your information here
  Developer("mslinn",
            "Mike Slinn",
            "mslinn@micronauticsresearch.com",
            url("https://github.com/mslinn")
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

libraryDependencies ++= Seq(
//  anorm,
//  cache,
//  evolutions,
//  filters,
  guice,
//  jdbc,
//  json,
//  ws,
//  "com.typesafe.play"      %% "play-mailer"        % "6.0.1" withSources(),
//  "com.typesafe.play" %% "play-mailer-guice" % "6.0.1" withSources(),
  "com.typesafe.akka"      %% "akka-slf4j"         % "2.5.25",
  "net.codingwell"         %% "scala-guice"        % "4.2.6",
  "org.webjars"            %% "webjars-play"       % "2.7.3",
  "org.webjars"            %  "bootstrap"          % "4.3.1",
//  "com.github.tototoshi"   %% "slick-joda-mapper"  % "2.4.1" withSources(),
  "com.typesafe"           %  "config"             % "1.3.4" withSources(),
//  "com.typesafe.slick"     %% "slick"              % "3.3.2" withSources(),
//  "com.typesafe.play"      %% "play-slick"         % "4.0.2" withSources(),
//  "org.postgresql"         % "postgresql"          % "42.2.8" withSources(),
  "org.webjars"            %  "jquery-ui"          % "1.12.1",
  "org.webjars"            %  "jquery-ui-themes"   % "1.12.1",
  //
  "org.scalatestplus.play" %% "scalatestplus-play" % "4.0.3" % Test,
  "junit"                  %  "junit"              % "4.12"  % Test
)

logBuffered in Test := false
logLevel := Level.Warn
logLevel in compile := Level.Warn
logLevel in test := Level.Info // Level.Info is needed to see detailed output when running tests

name         := "play27-template" // TODO change "play26-template" to a project name that you like

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

scalaVersion := "2.13.1"

scmInfo := Some(
  ScmInfo( // TODO change this for your project
    url(s"https://github.com/mslinn/$name"),
    s"git@github.com:mslinn/$name.git"
  )
)

version      := "0.4.0"

lazy val root = (project in file(".")).enablePlugins(PlayScala)
enablePlugins(ApiMappings)
