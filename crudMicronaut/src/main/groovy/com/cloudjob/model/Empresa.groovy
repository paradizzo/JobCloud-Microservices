package com.cloudjob.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.NotNull


@Entity
@Table(name = "empresas")
class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id
    @NotNull
    @Column
    String nome
    @NotNull
    @Column
    String email
    @NotNull
    @Column
    String cnpj
    @NotNull
    @Column
    String pais
    @NotNull
    @Column
    String cep
    @NotNull
    @Column
    String senha
    @NotNull
    @Column

    String toString() { "${this.class.name} : $id" }
}
