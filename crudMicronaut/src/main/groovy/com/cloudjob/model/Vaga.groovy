package com.cloudjob.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.NotNull

@Entity
@Table(name = "vagas")
class Vaga {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id
    @Column
    @NotNull
    String nome
    @Column
    @NotNull
    String descricao
    @Column
    @NotNull
    String estado
    @Column
    @NotNull
    String cidade
    @Column
    boolean angular
    @Column
    boolean java
    @Column
    boolean groovy
    @Column
    boolean typescript
    @Column
    boolean python


}
