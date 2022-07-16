package com.cloudjob.controller


import com.cloudjob.service.vagaSerializer
import com.cloudjob.model.Vaga
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.common.serialization.StringSerializer

class Kafka {
    static void enviaInfo(Vaga vaga) {

        Properties properties = new Properties()
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092")
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName())
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, vagaSerializer.class.getName())

        try(KafkaProducer<String, Vaga> producer = new KafkaProducer<String, Vaga>(properties)) {
            ProducerRecord<String, Vaga> record = new ProducerRecord<String, Vaga>("vagas", vaga)
            producer.send(record)
        }
    }

}
