package com.cloudjob.model

import spock.lang.*

class InserirVagasTest extends Specification {

    def "Teste registro de Vagas"() {
        when:
        String result = InserirVagas.registrarVagas("nomeVaga", "Vitoria", "ES", "descricaoVaga", "true", "true", "false", "false", "false")

        then:
        result == "A vaga foi inserida com sucesso"
    }
}

