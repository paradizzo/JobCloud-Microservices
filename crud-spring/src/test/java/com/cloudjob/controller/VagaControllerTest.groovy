package com.cloudjob.controller

import com.cloudjob.model.Vaga
import com.cloudjob.repository.VagaRepository
import spock.lang.*
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import static org.mockito.Mockito.*

class VagaControllerTest extends Specification {
    @Mock
    VagaRepository vagaRepository
    @InjectMocks
    VagaController vagaController

    def setup() {
        MockitoAnnotations.openMocks(this)
    }

    def "Teste de retorno nao nulo"() {
        when:
        Object result = vagaController.list()

        then:
        result != ""
    }

    def "Teste de criacao de vaga"() {
        when:
        Vaga result = vagaController.create(new Vaga(nome: "VagaSpec", estado: "ES", cidade: "Serra", id_empresas: 56, angular: true, java: true, python: true, typescript: true, groovy: true, descricao: "Teste unitario"))
        // Usei Id_empresas como 56, pq como não existe login eu estou usando max id ( Ultima empresa registrada )
        then:
        result == new Vaga(nome: "VagaSpec", estado: "ES", cidade: "Serra", id_empresas: 56, angular: true, java: true, python: true, typescript: true, groovy: true, descricao: "Teste unitario")
    }
}

