package com.microserviciospractica.pacientes.services;

import com.microserviciospractica.pacientes.domain.dto.PacienteDto;
import com.microserviciospractica.pacientes.domain.entities.PacienteEntity;

import java.util.List;
import java.util.Optional;

public interface IPacienteService {

    List<PacienteDto> getPacientes();

    void savePaciente(PacienteEntity pacienteEntity);

    void deletePaciente(Long id);

    Optional<PacienteDto> findPaciente(Long id);

    boolean isPatientExist(PacienteEntity pacienteEntity);
}
