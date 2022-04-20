import org.apache.kafka.clients.consumer.{ConsumerConfig, KafkaConsumer}
import java.util.Properties

object KafkaConsumer extends App {

  val props = new Properties()
  props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer")
  props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer")
  props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092")
  props.put(ConsumerConfig.GROUP_ID_CONFIG, "ANDZIA")

  val consumer = new KafkaConsumer[String, String](props)

  import scala.jdk.CollectionConverters._

  consumer.subscribe(Seq("adform").asJava)

  while (true) {
    val records = consumer.poll(100).asScala
    records.foreach { record =>
      System.out.printf("offset = %d, key = %s, value = %s%n", record.offset, record.key, record.value)
    }
  }

  consumer.close()
}
