package async
import java.io._
import scala.collection.mutable.ListBuffer
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.{Duration, SECONDS}
import scala.concurrent.{Await, Future, Promise}
import scala.util.{Failure, Success}

object FutureFirstCode {

  def main(args: Array[String]): Unit = {
    val p = Promise[String]()
    val f = p.future

    val producer = Future {
      val pythonProcess:ProcessBuilder = new ProcessBuilder("python","D:/IdeaProjects/ScalaPython/src/main/resources/python/addition.py")
      val prcessManager = pythonProcess.start()
      val ps = new PrintStream(prcessManager.getOutputStream)
      val reader = new BufferedReader(new InputStreamReader(prcessManager.getInputStream))
      var outputList = ListBuffer[String]()
      val nums = List(1,2,4,5,0)


      for(number <- nums){
        ps.println(number)
        ps.flush()

        var line = reader.readLine()
        if(line != null){
          outputList.append(line)
          println(line)
        }
      }
      p success outputList.toString()
    }

    val consumer = Future {
      f foreach { r => println(r)      }
    }

    Await.result(f,Duration.Inf)

  }


  def runPython(lst:List[Int]):Future[ListBuffer[String]]={
    val promise = Promise[ListBuffer[String]]()
    val output = callPython(lst)
    promise.success(output)
    promise.future
  }



  def callPython(givenList:List[Int]):ListBuffer[String]={
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
    outputList
  }

  def listBufferFunction(lst:ListBuffer[String]): Unit ={
    println(lst.toString())
  }
  }
