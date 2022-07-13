package com.cloudjob.model

import io.micronaut.core.annotation.Introspected

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

@Entity
@Table(name = "candidatos")
class Candidato {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id
    @NotNull
    @Column
    String nome
    @NotNull
    @Column
    String sobrenome
    @NotNull
    @Column
    String dataDeNascimento
    @NotNull
    @Column
    String email
    @NotNull
    @Column
    String cpf
    @NotNull
    @Column
    String pais
    @NotNull
    @Column
    String cep
    @NotNull
    @Column
    String descricao
    @NotNull
    @Column
    String senha
    @NotNull
    @Column
    boolean angular
    @NotNull
    @Column
    boolean java
    @NotNull
    @Column
    boolean groovy
    @NotNull
    @Column
    boolean typescript
    @NotNull
    @Column
    boolean python

    String toString() { "${this.class.name} : $id" }

}
