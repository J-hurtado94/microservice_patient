package com.microserviciospractica.pacientes.repositories;

import com.microserviciospractica.pacientes.domain.entities.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<PacienteEntity,Long> {
}
