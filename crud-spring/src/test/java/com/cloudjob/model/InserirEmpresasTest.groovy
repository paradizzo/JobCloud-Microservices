package com.cloudjob.model

import spock.lang.*

class InserirEmpresasTest extends Specification {

    def "Teste registro de candidato"() {
        when:
        String result = InserirEmpresas.registrarEmpresas("nomeEmpresa", "emailEmpresa", "12345678912345", "paisEmpresa", "29160772", "senhaEmpresa")

        then:
        result == "A empresa foi inserida com sucesso"
    }
}

