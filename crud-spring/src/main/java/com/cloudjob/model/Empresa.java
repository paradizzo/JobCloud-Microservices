package com.cloudjob.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 30, nullable = false)
    private String nome;

    @Column
    private String email;

    @Column( length = 14, nullable = false)
    private String cnpj;

    @Column(length = 30, nullable = false)
    private String pais;

    @Column(length = 8)
    private String cep;

    @Column
    private String senha;


}
