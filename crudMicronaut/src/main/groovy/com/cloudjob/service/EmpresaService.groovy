package com.cloudjob.service

import com.cloudjob.model.Empresa
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

import javax.validation.constraints.NotNull

@Repository
interface EmpresaService extends CrudRepository<Empresa, Integer> {

    Optional<Empresa> findById(@NotNull Integer id);

    Empresa save(@NotNull Empresa empresa);

    void deleteById(Integer id);

    List<Empresa> findAll();

    int update(@NotNull Integer id, Empresa empresa);

}
