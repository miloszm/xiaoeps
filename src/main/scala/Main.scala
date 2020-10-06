object Main extends App {
  val server = WebServiceBuilder.buildWebService(8090, classOf[WebService])
  server.start()
}
