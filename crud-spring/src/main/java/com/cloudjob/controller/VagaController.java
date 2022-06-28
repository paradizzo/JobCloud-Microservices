package com.cloudjob.controller;

import com.cloudjob.connection.connection;
import com.cloudjob.model.Empresa;
import com.cloudjob.model.InserirEmpresas;
import com.cloudjob.model.InserirVagas;
import com.cloudjob.model.Vaga;
import com.cloudjob.repository.EmpresaRepository;
import com.cloudjob.repository.VagaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/vagas")
@AllArgsConstructor
public class VagaController {
    private final VagaRepository vagaRepository;

    @GetMapping
    public @ResponseBody
    Object list() {
        String BUSCAR_VAGAS = "SELECT JSON_AGG(vagas) AS vaga FROM(SELECT vagas.id, vagas.nome, vagas.descricao, vagas.estado, vagas.cidade, vagas.id_empresas, vagas.competencias FROM vagas) vagas";
        try {
            Connection conn = connection.conexao();
            PreparedStatement vaga = conn.prepareStatement(BUSCAR_VAGAS, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resVaga = vaga.executeQuery();
            resVaga.last();
            int quantidadeVagas = resVaga.getRow();
            resVaga.beforeFirst();

            if (quantidadeVagas == 0) {
                System.out.println("Não existem Vagas");
            }
            while (resVaga.next() )
            {
                return resVaga.getString(1);
            }

        } catch(Exception e){
            e.printStackTrace();
            System.err.println("Erro buscando vagas");
            System.exit(-42);
        }
        return vagaRepository.findAll();
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public Vaga create(@RequestBody Vaga vaga) {
        String nomeVaga = vaga.getNome();
        String descricaoVaga = vaga.getDescricao();
        String estadoVaga = vaga.getEstado();
        String localVaga = vaga.getCidade();
        String idEmpresaVaga = vaga.getId_empresas();
        String angularVaga = vaga.getAngular();
        String javaVaga = vaga.getJava();
        String groovyVaga = vaga.getGroovy();
        String pythonVaga = vaga.getPython();
        String typescriptVaga = vaga.getTypescript();
        InserirVagas.registrarVagas( nomeVaga,  localVaga,  estadoVaga,  descricaoVaga,  angularVaga,  javaVaga,  groovyVaga,  pythonVaga,  typescriptVaga);

        return vagaRepository.save(vaga);
    }
}
