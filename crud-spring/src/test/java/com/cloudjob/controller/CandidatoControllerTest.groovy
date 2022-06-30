package com.cloudjob.controller

import com.cloudjob.model.Candidato
import com.cloudjob.repository.CandidatoRepository
import spock.lang.*
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import static org.mockito.Mockito.*

class CandidatoControllerTest extends Specification {

    @Mock
    CandidatoRepository candidatoRepository
    @InjectMocks
    CandidatoController candidatoController

    def setup() {
        MockitoAnnotations.openMocks(this)
    }

    def "Teste de retorno nao nulo"() {
        when:
        Object result = candidatoController.list()

        then:
        result != ""
    }

    def "Teste de criacao de candidato"() {
        when:
        Candidato result = candidatoController.create(new Candidato(nome: "Lucas", sobrenome: "SpecTest", pais: "Brasil", cpf: "16777031723", cep: "29160772", angular: true, java: false, python: true, typescript: false, groovy: true, senha: "1234567", dataDeNascimento: "1998-12-01", formacao: null,  email: "lucasparadizzo@gmail.com", descricao: "Amor, viver e testar" ))

        then:
        result == new Candidato(nome: "Lucas", sobrenome: "SpecTest", pais: "Brasil", cpf: "16777031723", cep: "29160772", angular: true, java: false, python: true, typescript: false, groovy: true, senha: "1234567", dataDeNascimento: "1998-12-01", formacao: null,  email: "lucasparadizzo@gmail.com", descricao: "Amor, viver e testar" )
    }
}

