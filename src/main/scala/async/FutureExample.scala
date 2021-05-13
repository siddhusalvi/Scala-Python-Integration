package async

import java.io.{BufferedReader, InputStreamReader, PrintStream}
import scala.collection.mutable.ListBuffer
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Future, Promise}
import scala.util.{Failure, Success}

object FutureExample {

  def main(args: Array[String]): Unit = {


    val nums = List(1,2,4,5,0)

    val results : Future[String] = Future{

      val pythonProcess:ProcessBuilder = new ProcessBuilder("python","D:/IdeaProjects/ScalaPython/src/main/resources/python/addition.py")
      val prcessManager = pythonProcess.start()
      val ps = new PrintStream(prcessManager.getOutputStream)
      val reader = new BufferedReader(new InputStreamReader(prcessManager.getInputStream))
      var outputList = ListBuffer[String]()

      for(number <- nums){
        ps.println(number)
        ps.flush()

        var line = reader.readLine()
        if(line != null){
          outputList.append(line)
        }
      }
      outputList.toString()

    }

    results.foreach(println(_))


  }

  def callPython(givenList:List[Int]):String={
    val pythonProcess:ProcessBuilder = new ProcessBuilder("python","D:/IdeaProjects/ScalaPython/src/main/resources/python/addition.py")
    val prcessManager = pythonProcess.start()
    val ps = new PrintStream(prcessManager.getOutputStream)
    val reader = new BufferedReader(new InputStreamReader(prcessManager.getInputStream))
    var outputList = ListBuffer[String]()

    for(number <- givenList){
      ps.println(number)
      ps.flush()

      var line = reader.readLine()
      if(line != null){
        outputList.append(line)
      }
    }
    outputList.toString()
  }

}
