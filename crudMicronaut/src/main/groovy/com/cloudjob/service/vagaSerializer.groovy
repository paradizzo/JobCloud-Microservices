package com.cloudjob.service

import com.cloudjob.model.Vaga
import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.kafka.common.serialization.Serializer

class vagaSerializer implements Serializer<Vaga> {

    @Override
    byte[] serialize(String topic, Vaga vaga) {
        return new ObjectMapper().writeValueAsBytes(vaga)
    }
}
