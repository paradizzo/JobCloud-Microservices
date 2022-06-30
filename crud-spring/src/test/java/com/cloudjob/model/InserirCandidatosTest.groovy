package com.cloudjob.model

import spock.lang.*

class InserirCandidatosTest extends Specification {

    def "Teste registro de candidato"() {
        when:
        String result = InserirCandidatos.registrarCandidatos("Lucas", "TesteUnitario", "1998-01-12", "emailCandidato", "16777031723", "paisCandidato", "29160772", "formacaoCandidato", "descricaoCandidato", "12345678", "angularCandidato", "javaCandidato", "groovyCandidato", "pythonCandidato", "typescriptCandidato")

        then:
        result == "O candidato foi inserido com sucesso"
    }
}

