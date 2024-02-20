package com.example.edadDeUnaPersona.controller;

import java.time.LocalDate;
import java.time.Period;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.time.format.DateTimeParseException;

@RestController
public class EdadPersonaController {

    @GetMapping("/{dia}/{mes}/{anio}")
    public int calcularEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio) {

        try {
            LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
            LocalDate fechaActual = LocalDate.now();

            // Calcular la edad
            Period periodo = Period.between(fechaNacimiento, fechaActual);
            if(dia >= 1 && dia <= 31 && mes >=1 && mes <= 12 && anio >= 1 && fechaNacimiento.isBefore(fechaActual)) {
                int edad = periodo.getYears();
                return edad;
            }
            else {
                return -1;
            }
        }
        catch (DateTimeParseException e){
            return -1;
        }

    }
}
