package com.cloudjob

import com.cloudjob.controller.CandidatoController
import com.cloudjob.controller.EmpresaController
import com.cloudjob.controller.VagaController
import com.cloudjob.model.Candidato
import com.cloudjob.model.Empresa
import com.cloudjob.model.InserirCandidatos;
import com.cloudjob.model.InserirEmpresas
import com.cloudjob.model.InserirVagas
import com.cloudjob.model.Vaga
import com.cloudjob.repository.CandidatoRepository
import com.cloudjob.repository.EmpresaRepository
import com.cloudjob.repository.VagaRepository;
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import spock.lang.Specification;

@SpringBootTest
class CrudSpringApplicationTests extends Specification {
    @Mock
    CandidatoRepository candidatoRepository
    @InjectMocks
    CandidatoController candidatoController

    @Mock
    VagaRepository vagaRepository
    @InjectMocks
    VagaController vagaController

    @Mock
    EmpresaRepository empresaRepository
    @InjectMocks
    EmpresaController empresaController

    def setup() {
        MockitoAnnotations.openMocks(this)
    }

    def "Teste de retorno nao nulo candidato"() {
        when:
        Object result = candidatoController.list()

        then:
        result != ""
    }
    def "Teste de criacao de candidato"() {
        given:
        Candidato candidato = new Candidato(nome: "Lucas", sobrenome: "SpecTest", pais: "Brasil", cpf: "16777031723", cep: "29160772", angular: true, java: false, python: true, typescript: false, groovy: true, senha: "1234567", dataDeNascimento: "1998-12-01", formacao: null,  email: "lucasparadizzo@gmail.com", descricao: "Amor, viver e testar" )

        when:
        Candidato result = candidatoController.create(candidato)

        then:
        result == new Candidato(nome: "Lucas", sobrenome: "SpecTest", pais: "Brasil", cpf: "16777031723", cep: "29160772", angular: true, java: false, python: true, typescript: false, groovy: true, senha: "1234567", dataDeNascimento: "1998-12-01", formacao: null,  email: "lucasparadizzo@gmail.com", descricao: "Amor, viver e testar" )
    }




    def "Teste de retorno nao nulo empresa"() {
        when:
        Object result = empresaController.list()

        then:
        result != ""
    }
    def "Teste de criacao de empresa"() {
        given:
        Empresa empresa = new Empresa(nome: "Empresa teste", email: "empresaTeste@gmail.com", cnpj: "12345678912345", pais: "Brasil", cep: "29160772", senha: "1234567")

        when:
        Empresa result = empresaController.create(empresa)

        then:
        result == new Empresa(nome: "Empresa teste", email: "empresaTeste@gmail.com", cnpj: "12345678912345", pais: "Brasil", cep: "29160772", senha: "1234567")
    }





    def "Teste de retorno nao nulo vaga"() {
        when:
        Object result = vagaController.list()

        then:
        result != ""
    }
    def "Teste de criacao de vaga"() {
        given:
        Vaga vaga = new Vaga(nome: "VagaSpec", estado: "ES", cidade: "Serra", id_empresas: 56, angular: true, java: true, python: true, typescript: true, groovy: true, descricao: "Teste unitario")

        when:
        Vaga result = vagaController.create(vaga)
        // Usei Id_empresas como 56, pq como não existe login eu estou usando max id ( Ultima empresa registrada )
        then:
        result == new Vaga(nome: "VagaSpec", estado: "ES", cidade: "Serra", id_empresas: 56, angular: true, java: true, python: true, typescript: true, groovy: true, descricao: "Teste unitario")
    }

    def "Teste registro de candidato"() {
        when:
        String result = InserirCandidatos.registrarCandidatos("Lucas", "TesteUnitario", "1998-01-12", "emailCandidato", "16777031723", "paisCandidato", "29160772", "formacaoCandidato", "descricaoCandidato", "12345678", "angularCandidato", "javaCandidato", "groovyCandidato", "pythonCandidato", "typescriptCandidato")

        then:
        result == "O candidato foi inserido com sucesso"
    }

    def "Teste registro de empresa"() {
        when:
        String result = InserirEmpresas.registrarEmpresas("nomeEmpresa", "emailEmpresa", "12345678912345", "paisEmpresa", "29160772", "senhaEmpresa")

        then:
        result == "A empresa foi inserida com sucesso"
    }

    def "Teste registro de Vagas"() {
        when:
        String result = InserirVagas.registrarVagas("nomeVaga", "Vitoria", "ES", "descricaoVaga", "true", "true", "false", "false", "false")

        then:
        result == "A vaga foi inserida com sucesso"
    }
}
