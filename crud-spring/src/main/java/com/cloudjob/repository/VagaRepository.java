package com.cloudjob.repository;

import com.cloudjob.model.Empresa;
import com.cloudjob.model.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VagaRepository extends JpaRepository<Vaga, Long> {
}
