package com.microserviciospractica.pacientes.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PacienteDto {


    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private String telefono;
}
