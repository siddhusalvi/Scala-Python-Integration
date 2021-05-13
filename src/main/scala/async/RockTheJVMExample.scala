package async

import java.io.FileWriter
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Promise

object RockTheJVMExample {

  def main(args: Array[String]): Unit = {
    val promise = Promise[String]

    val future = promise.future

    val processedPromise = future.map(_.toUpperCase())

    def asyncCall(promise:Promise[String]):Unit={
      promise.success("this is promise.")
    }

    asyncCall(promise)

    processedPromise.foreach(writeFile(_))

    Thread.sleep(2000)

  }

  def writeFile(text : String) =  {
    val fw = new FileWriter("D:/IdeaProjects/ScalaPython/src/main/resources/FutureOutput.txt", true)
    try {
      fw.write(text)
      fw.write("\n")
    }
    finally fw.close()
  }

}
