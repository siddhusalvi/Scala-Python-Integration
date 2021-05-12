import java.io.PrintStream
import scala.io.Source

object ProcessMaker {
  def main(args: Array[String]): Unit = {

    System.out.println("Program starts at " + System.currentTimeMillis + " ms")
    val pb = new ProcessBuilder("python", "D:/IdeaProjects/ScalaPython/src/main/resources/script.py")
    val tr = pb.start
    val ps = new PrintStream(tr.getOutputStream)

    val filedata = Source.fromFile("src/main/resources/data.txt").getLines

    for (line <- filedata) {
      ps.println(line)
      ps.flush()
    }

    ps.println("x")
    ps.flush()

    System.out.println("Program ends at " + System.currentTimeMillis + " ms")

  }

}
