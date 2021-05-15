package streaming
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.spark.sql.SparkSession
import org.apache.spark.streaming.dstream.InputDStream
import org.apache.spark.streaming.{Milliseconds, StreamingContext}
import org.apache.spark.streaming.kafka010._
import org.apache.spark.streaming.kafka010.LocationStrategies.PreferConsistent
import org.apache.spark.streaming.kafka010.ConsumerStrategies.Subscribe

import scala.concurrent.ExecutionContext.Implicits.global
import parser.Parser

import java.io.{BufferedReader, InputStreamReader, PrintStream}
import scala.collection.mutable.ListBuffer
import scala.concurrent.Await
import scala.concurrent.duration.Duration
object StreamingDemo1 {
  def main(args: Array[String]): Unit = {

    //Spark setup (3.00 ,2.12)
    val spark = SparkSession.builder()
      .master("local[2]")
      .appName("SparkAsyncDemo1")
      .config("spark.scheduler.mode", "FAIR")
      .getOrCreate()

    val sparkContext = spark.sparkContext

    val ssc = new StreamingContext(sparkContext, Milliseconds(1000))

    val kafkaParams = Map[String, Object](
      "bootstrap.servers" -> "localhost:9092",
      "key.deserializer" -> classOf[StringDeserializer],
      "value.deserializer" -> classOf[StringDeserializer],
      "group.id" -> "testgroup",
      "auto.offset.reset" -> "latest",
      "enable.auto.commit" -> (false: java.lang.Boolean)
    )

    val topics = Array("test")

    val stream = KafkaUtils.createDirectStream[String,String](ssc,PreferConsistent,Subscribe[String,String](topics,kafkaParams))

    val command = "python D:/IdeaProjects/ScalaPython/src/main/resources/python/double.py"

    stream.foreachRDD {
      rdd =>val sc = rdd.pipe(command)
        .collectAsync()
        .map(IOdata => println(IOdata))
      }


    ssc.start()
    ssc.awaitTermination()

  }


}
