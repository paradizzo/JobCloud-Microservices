package com.cloudjob.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
public class Candidato {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 30, nullable = false)
    private String nome;

    @Column( length = 30, nullable = false)
    private String sobrenome;

    @Column(length = 30, nullable = false)
    private String pais;

    @Column( length = 11, nullable = false)
    private String cpf;

    @Column(length = 8)
    private String cep;

    @Column
    private String angular;
    @Column
    private String java;
    @Column
    private String python;
    @Column
    private String typescript;
    @Column
    private String groovy;

    @Column
    private String senha;

    @Column
    private String dataDeNascimento;

    @Column
    private  String formacao;

    @Column
    private String email;

    @Column
    private String descricao;

}
