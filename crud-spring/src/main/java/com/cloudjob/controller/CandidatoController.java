package com.cloudjob.controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cloudjob.connection.connection;
import com.cloudjob.model.Candidato;
import com.cloudjob.model.InserirCandidatos;
import com.cloudjob.repository.CandidatoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/candidatos")
@AllArgsConstructor
public class CandidatoController {

    private final CandidatoRepository candidatoRepository;

    @GetMapping
    public @ResponseBody
    Object list() {
        String BUSCAR_CANDIDATOS = "SELECT JSON_AGG(candidatos) AS candidato FROM(SELECT candidatos.id, candidatos.nome, candidatos.sobrenome, candidatos.data_de_nascimento, candidatos.email, candidatos.cpf, candidatos.pais, candidatos.cep, candidatos.descricao, candidatos.senha, candidatos.angular, candidatos.groovy, candidatos.typescript, candidatos.java, candidatos.python FROM candidatos) candidatos";
        try {
            Connection conn = connection.conexao();
            PreparedStatement candidatos = conn.prepareStatement(BUSCAR_CANDIDATOS, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resCandidato = candidatos.executeQuery();
            resCandidato.last();
            int quantidadeCandidatos = resCandidato.getRow();
            resCandidato.beforeFirst();

            if (quantidadeCandidatos == 0) {
                System.out.println("Não existem candidatos");
            }
            while (resCandidato.next() )
            {
                return resCandidato.getString(1);
            }

        } catch(Exception e){
            e.printStackTrace();
            System.err.println("Erro buscando candidatos");
            System.exit(-42);
        }
        return candidatoRepository.findAll();
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public Candidato create(@RequestBody Candidato candidato) {
        String nomeCandidato = candidato.getNome();
        String sobrenome = candidato.getSobrenome();
        String nascimentoCandidato = candidato.getDataDeNascimento();
        String emailCandidato = candidato.getEmail();
        String cpfCandidato = candidato.getCpf();
        String paisCandidato = candidato.getPais();
        String cepCandidato = candidato.getCep();
        String formacaoCandidato = candidato.getFormacao();
        String descricaoCandidato = candidato.getDescricao();
        String senhaCandidato = candidato.getSenha();
        String angularCandidato = candidato.getAngular();
        String javaCandidato = candidato.getJava();
        String groovyCandidato = candidato.getGroovy();
        String pythonCandidato = candidato.getPython();
        String typescriptCandidato = candidato.getTypescript();
        InserirCandidatos.registrarCandidatos(nomeCandidato,  sobrenome,  nascimentoCandidato, emailCandidato,  cpfCandidato,  paisCandidato,  cepCandidato, formacaoCandidato, descricaoCandidato, senhaCandidato, angularCandidato, javaCandidato,  groovyCandidato,  pythonCandidato, typescriptCandidato);
        candidatoRepository.save(candidato);
        return  candidato;
    }

}
