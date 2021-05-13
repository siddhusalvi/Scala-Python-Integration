package basic
import java.io.{BufferedReader, InputStreamReader, PrintStream}
import scala.io.Source

object ProcessMaker {
  def main(args: Array[String]): Unit = {

    System.out.println("Program starts at " + System.currentTimeMillis + " ms")
    val pb = new ProcessBuilder("python", "D:/IdeaProjects/ScalaPython/src/main/resources/python/script.py")
    val tr = pb.start
    val ps = new PrintStream(tr.getOutputStream)
    val reader = new BufferedReader(new InputStreamReader(tr.getInputStream))
    val filedata = Source.fromFile("src/main/resources/data.txt").getLines


    for (line <- filedata) {
      ps.println(line)
      ps.flush()
    }

    ps.println("x")
    ps.flush()

    var line = reader.readLine
    if( line!= null)
    System.out.println(line)

    System.out.println("Program ends at " + System.currentTimeMillis + " ms")

  }

}
