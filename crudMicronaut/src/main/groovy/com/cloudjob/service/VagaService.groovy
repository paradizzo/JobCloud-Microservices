package com.cloudjob.service

import com.cloudjob.model.Vaga
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

import javax.validation.constraints.NotNull

@Repository
interface VagaService extends CrudRepository<Vaga, Integer> {

    Optional<Vaga> findById(@NotNull Integer id);

    Vaga save(@NotNull Vaga vaga);

    void deleteById(Integer id);

    List<Vaga> findAll();

    int update(@NotNull Integer id, Vaga vaga);

}