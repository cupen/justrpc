name := "justrpc"

organization := "freer"

version := "0.1.0"

description := "Just a rpc library for java."

publishMavenStyle := true

crossPaths := false

autoScalaLibrary := false

javacOptions ++= Seq("-encoding", "UTF-8")
// javacOptions in (Compile, compile) ++= Seq("-source", "1.7", "-target", "1.7", "-g:lines")

libraryDependencies ++= Seq(
   "com.typesafe.akka" % "akka-actor" % "2.4.12",
   "com.typesafe.akka" % "akka-slf4j" % "2.4.12",
   "org.msgpack"       % "msgpack-core" % "*"
   
)