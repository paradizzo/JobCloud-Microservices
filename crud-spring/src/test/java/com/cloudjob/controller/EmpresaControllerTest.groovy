package com.cloudjob.controller

import com.cloudjob.model.Empresa
import com.cloudjob.repository.EmpresaRepository
import spock.lang.*
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import static org.mockito.Mockito.*

class EmpresaControllerTest extends Specification {
    @Mock
    EmpresaRepository empresaRepository
    @InjectMocks
    EmpresaController empresaController

    def setup() {
        MockitoAnnotations.openMocks(this)
    }

    def "Teste de retorno nao nulo"() {
        when:
        Object result = empresaController.list()

        then:
        result != ""
    }

    def "Teste de criacao de empresa"() {
        when:
        Empresa result = empresaController.create(new Empresa(nome: "Empresa teste", email: "empresaTeste@gmail.com", cnpj: "12345678912345", pais: "Brasil", cep: "29160772", senha: "1234567"))

        then:
        result == new Empresa(nome: "Empresa teste", email: "empresaTeste@gmail.com", cnpj: "12345678912345", pais: "Brasil", cep: "29160772", senha: "1234567")
    }
}

