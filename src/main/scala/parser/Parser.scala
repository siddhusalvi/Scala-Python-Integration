package parser

import org.apache.kafka.clients.consumer.ConsumerRecord
import org.apache.spark.SparkContext

import java.io.{BufferedReader, InputStreamReader, PrintStream}
import scala.collection.mutable.ListBuffer

object Parser {

  def Parse(iterator:Iterator[ConsumerRecord[String,String]], sparkContext:SparkContext): Unit ={

    val list = iterator.toList.map(_.value())

    println(list)

  }

  def callPython(number:String):String={
    val pythonProcess:ProcessBuilder = new ProcessBuilder("python","D:/IdeaProjects/ScalaPython/src/main/resources/python/double.py")
    val prcessManager = pythonProcess.start()
    val ps = new PrintStream(prcessManager.getOutputStream)
    val reader = new BufferedReader(new InputStreamReader(prcessManager.getInputStream))

    ps.println(number)
    ps.flush()

    var output = "null"
    var line = reader.readLine()
    if(line != null){
        output = line
      }
    number + " : "+ output
   }

}
