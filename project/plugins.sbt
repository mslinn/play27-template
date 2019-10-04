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

import sbt._
import sbt.Keys._

// Comment to get more information during initialization
//logLevel := Level.Warn

addSbtPlugin("com.typesafe.play" % "sbt-plugin"       % "2.7.3")

// optional plugins
//addSbtPlugin("com.typesafe.sbt"  % "sbt-coffeescript" % "1.0.2")
//addSbtPlugin("com.typesafe.sbt"  % "sbt-less"         % "1.1.2")
//addSbtPlugin("com.typesafe.sbt"  % "sbt-jshint"       % "1.0.6")
//addSbtPlugin("com.typesafe.sbt"  % "sbt-rjs"          % "1.0.10")
//addSbtPlugin("com.typesafe.sbt" % "sbt-digest"        % "1.1.3")
//addSbtPlugin("com.typesafe.sbt" % "sbt-mocha"         % "1.1.2")

// See https://github.com/jrudolph/sbt-dependency-graph
//addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.10.0-RC1")

addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "5.2.4")

addSbtPlugin("com.timushev.sbt" % "sbt-updates" % "0.4.2")

addSbtPlugin("com.thoughtworks.sbt-api-mappings" % "sbt-api-mappings" % "3.0.0")

libraryDependencies ++= Seq(
  "com.puppycrawl.tools" % "checkstyle" % "8.25"
)
