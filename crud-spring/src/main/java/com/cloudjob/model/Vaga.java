package com.cloudjob.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Vaga {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 30, nullable = false)
    private String nome;

    @Column(length = 30, nullable = false)
    private String estado;

    @Column( length = 30, nullable = false)
    private String cidade;

    @Column(length = 8)
    private String id_empresas;

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
    private String descricao;


}
