package async
import
java.io.{BufferedReader, InputStreamReader, PrintStream}
import scala.collection.mutable.ListBuffer
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, Future, Promise}
import scala.util.{Failure, Success}
import scala.concurrent.duration._

object PromiseExample {
  def main(args: Array[String]): Unit = {

    //Creating promise
    val p = Promise[List[String]]()

    //extracting future
    val f = p.future

    val nums = List(1,2,4,5,0)

    // adding single number one by one
    //Assigning Future to the promise

    val task =
      Future{ callPython(nums).toList}

    p completeWith(task)

    //some code
    println("running code after calling Future block")

    //Attaching callbacks
    task onComplete {
      case Success(result) => println(result)
      case Failure(t) => println("An error has occurred: " + t.getMessage)
    }

    Await.ready(task,Duration.Inf)
    println("blocked code till future operation")

    //Waiting for infinite time to complete the async operation
    Await.result(f,Duration.Inf)
  }

  def callPython(nums:List[Int]):ListBuffer[String]={
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
    outputList
  }

}

