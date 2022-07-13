package com.cloudjob.service

import com.cloudjob.model.Candidato
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

import javax.validation.constraints.NotNull

@Repository
interface CandidatoService extends CrudRepository<Candidato, Integer> {

    Optional<Candidato> findById(@NotNull Integer id);

    Candidato save(@NotNull Candidato candidato);

    void deleteById(Integer id);

    List<Candidato> findAll();

    int update(@NotNull Integer id, Candidato candidato);

}
