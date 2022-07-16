package kafka.service

import com.fasterxml.jackson.databind.ObjectMapper
import kafka.model.Vaga
import org.apache.kafka.common.serialization.Deserializer

class VagaDeserializer implements Deserializer<Vaga> {

    @Override
    Vaga deserialize(String topic, byte[] vaga) {
        return new ObjectMapper().readValue(vaga, Vaga.class)
    }
}
