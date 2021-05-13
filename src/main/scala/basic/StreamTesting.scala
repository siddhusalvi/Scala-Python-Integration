import org.apache.spark.sql.SparkSession
import org.apache.spark.streaming.dstream.DStream
import org.apache.spark.streaming.{Seconds, StreamingContext}

import scala.util.control.NonFatal

object StreamTesting {
  def main(args: Array[String]): Unit = {
    try {
      val spark = SparkSession.builder()
        .master("local[2]")
        .appName("ScalaPython")
        .getOrCreate()

      val sparkContext = spark.sparkContext

      val ssc = new StreamingContext(sparkContext, Seconds(1))


      ssc.checkpoint("D:/IdeaProjects/ScalaPython/checkpoint/")

//      val dir ="file://D:/IdeaProjects/ScalaPython/src\\main\\resources\\"

      val sourceDir: String = "file:\\src\\main\\resources\\"
      val stream: DStream[String] = ssc.textFileStream(sourceDir)

      case class TextLine(line: String)

      val lineRdd: DStream[TextLine] = stream.map(TextLine)

      lineRdd.foreachRDD(rdd => {
        val words = rdd.flatMap(rdd => rdd.line.split(" "))
        val pairs = words.map(word => (word, 1))
        val wordCounts = pairs.reduceByKey(_ + _)

        println("=====================")
        wordCounts.foreach(println)
        println("=====================" + rdd.count())
      })


      ssc.start()
      ssc.awaitTermination()

    } catch {
      case NonFatal(e) =>
        print("Error in main : " + e.printStackTrace())

    }

  }
}
