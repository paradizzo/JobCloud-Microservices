package kafka.service

import kafka.controller.EmailFactory
import kafka.model.Vaga
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.apache.kafka.clients.consumer.ConsumerRecords
import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.kafka.common.serialization.StringDeserializer

import java.time.Duration

class ProcessadorVaga {
    EmailFactory emailFactory = new EmailFactory()
    void processaVaga(){

        Properties properties = new Properties()
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092")
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName())
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, VagaDeserializer.class.getName())
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "vagas-group")
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest")

        try(KafkaConsumer<String, Vaga> consumer = new KafkaConsumer<>(properties)) {
            consumer.subscribe(Arrays.asList("vagas"))
            while (true) {
                ConsumerRecords<String, Vaga> vagas = consumer.poll(Duration.ofMillis(300))
                for (ConsumerRecord<String, Vaga> record : vagas){
                    Vaga vaga = record.value()
                    emailFactory.mandaEmail(vaga.nome , vaga.estado, vaga.cidade )
                }
            }
        }
    }
}
