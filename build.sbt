name := "xiaoeps"

version := "0.1"

scalaVersion := "2.13.1"

libraryDependencies ++= Seq(
  "org.scalatra" %% "scalatra" % "2.7.0",
  "org.eclipse.jetty" % "jetty-webapp" % "9.4.30.v20200611",
  "com.github.briandilley.jsonrpc4j"  % "jsonrpc4j" % "1.5.3",
  "javax.portlet" % "portlet-api" % "3.0.1"
)
