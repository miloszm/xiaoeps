import com.fasterxml.jackson.databind.ObjectMapper
import com.googlecode.jsonrpc4j.{JsonRpcBasicServer, JsonRpcMethod, JsonRpcServer, JsonRpcService}
import javax.servlet.ServletConfig
import javax.servlet.http.{HttpServletRequest, HttpServletResponse}
import org.scalatra.ScalatraServlet

@JsonRpcService("/service")
trait ElectrumService {
  def testMe(x: Int): Int = x
  @JsonRpcMethod("abc")
  def abc(): Int
  @JsonRpcMethod("server.version")
  def serverVersion(v1: String, v2: String): String
}

class ElectrumServiceImpl extends ElectrumService {
  override def testMe(x: Int): Int = {
    println(s"testme called with $x")
    x
  }
  override def abc() = 3
  override def serverVersion(v1: String, v2: String): String = "xmm3"
}


class WebService extends ScalatraServlet {
  get("/"){
    "Scalatra rules!"
  }

  lazy val rpcServer = new JsonRpcServer(new ObjectMapper(), new ElectrumServiceImpl(), classOf[ElectrumService])

  override def handle(request: HttpServletRequest, response: HttpServletResponse): Unit = {
    rpcServer.handle(request, response)
  }

//  override def init(config: ServletConfig): Unit = {
//    val service = new ElectrumServiceImpl
//    rpcServer = new JsonRpcServer(new ObjectMapper(), classOf[ElectrumService])
//    super.init(config)
//  }
}
