package kafka

import org.apache.kafka.clients.producer.{KafkaProducer, Producer, ProducerRecord}

import java.util.Properties

object Producer {
  def main(args: Array[String]): Unit = {

    val producer = kafkaProducer()
    val topic = "test"

    var counter = 1
    while(true) {
      Thread.sleep(700)
      val record = new ProducerRecord[String, String]("test", counter.toString)
      producer.send(record)
      println(counter)
      counter += 1
    }
  }

  def kafkaProducer(): KafkaProducer[String,String] = {
    val props = new Properties()
    props.put("bootstrap.servers", "localhost:9092")
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    val producer = new KafkaProducer[String, String](props)
    producer
  }
}


