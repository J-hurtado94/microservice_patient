package com.microserviciospractica.pacientes.controller;

import com.microserviciospractica.pacientes.domain.dto.PacienteDto;
import com.microserviciospractica.pacientes.domain.entities.PacienteEntity;
import com.microserviciospractica.pacientes.services.IPacienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class PacienteController {
    private final IPacienteService pacienteService;

    @PutMapping("/paciente/{id}")
    public ResponseEntity<?> createUpdatePaciente(@PathVariable final Long id, @RequestBody final PacienteEntity pacienteEntity) {

        pacienteEntity.setIdPaciente(id);
        final boolean isPatientExist = pacienteService.isPatientExist(pacienteEntity);
        pacienteService.savePaciente(pacienteEntity);

        if (isPatientExist) {
            return new ResponseEntity<>(null, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(null, HttpStatus.CREATED);
        }


    }

    @PostMapping("/paciente/crear")
    public ResponseEntity<?> crearPaciente(@RequestBody final PacienteEntity pacienteEntity){
        pacienteService.savePaciente(pacienteEntity);
        return new ResponseEntity<>(null,HttpStatus.CREATED);

    }

    @GetMapping("/paciente/{id}")
    public ResponseEntity<?> getPatient(@PathVariable final Long id) {

        final Optional<PacienteDto> pacienteEncontrado = pacienteService.findPaciente(id);
        return pacienteEncontrado
                .map(pacienteDto -> new ResponseEntity<PacienteDto>(pacienteDto, HttpStatus.OK))
                .orElse(new ResponseEntity("No encontrado",HttpStatus.NOT_FOUND));
    }

    /*@GetMapping("/pacientes")
    public ResponseEntity<List<PacienteDto>> getPacientes() {
        return new ResponseEntity<>(pacienteService.getPacientes(), HttpStatus.OK);
    }*/

    @GetMapping("/pacientes")
    public String getPacientes() {
        return "Prueba devops pipeline";
    }


    @DeleteMapping("/paciente/{id}")
    public ResponseEntity deleteBook(@PathVariable final Long id) {
        pacienteService.deletePaciente(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}


