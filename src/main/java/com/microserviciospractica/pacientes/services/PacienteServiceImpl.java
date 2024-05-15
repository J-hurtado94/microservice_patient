package com.microserviciospractica.pacientes.services;

import com.microserviciospractica.pacientes.domain.dto.PacienteDto;
import com.microserviciospractica.pacientes.domain.entities.PacienteEntity;
import com.microserviciospractica.pacientes.repositories.PacienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PacienteServiceImpl implements IPacienteService {

    private final PacienteRepository pacienteRepository;


    private PacienteDto pacienteEntityToPacienteDto(PacienteEntity pacienteEntity) {
        return PacienteDto.builder()
                .nombre(pacienteEntity.getNombre())
                .apellido(pacienteEntity.getApellido())
                .telefono(pacienteEntity.getTelefono())
                .fechaNacimiento(pacienteEntity.getFechaNacimiento())
                .build();
    }

    @Override
    public List<PacienteDto> getPacientes() {
        final List<PacienteEntity> pacientesEncontrados = pacienteRepository.findAll();
        return pacientesEncontrados.stream().map(pacienteDto -> pacienteEntityToPacienteDto(pacienteDto)).toList();
    }

    @Override
    public void savePaciente(PacienteEntity pacienteEntity) {
        pacienteRepository.save(pacienteEntity);

    }

    @Override
    public void deletePaciente(Long id) {
        pacienteRepository.deleteById(id);
    }

    @Override
    public Optional<PacienteDto> findPaciente(Long id) {
        final Optional<PacienteEntity> pacienteEncontrado = pacienteRepository.findById(id);
        return pacienteEncontrado.map(pacienteDto -> pacienteEntityToPacienteDto(pacienteDto));
    }

    @Override
    public boolean isPatientExist(PacienteEntity pacienteEntity) {
        return pacienteRepository.existsById(pacienteEntity.getIdPaciente());
    }
}
