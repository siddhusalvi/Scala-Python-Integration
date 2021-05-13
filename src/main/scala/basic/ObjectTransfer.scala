package basic
import com.google.gson.Gson
import org.json.JSONObject
import sys.process._
import scala.sys.process.ProcessLogger


class ListPacket(nums:List[Int])
object ObjectTransfer {
  def main(args: Array[String]): Unit = {

    var packet = new Packet()
    packet.nums = List(10, 20, 30, 40).toArray

    val gson = new Gson()
    val obj = gson.toJson(packet)

    val scriptPath = "python D:/IdeaProjects/ScalaPython/src/main/resources/std.py"
    println(obj)

    val command = scriptPath + " " + obj
    val result = command !! ProcessLogger(stdout append _, stderr append _)

    println(result)
    println("stdout: " + stdout)
    println("stderr: " + stderr)
  }
}
