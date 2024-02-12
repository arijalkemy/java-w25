package org.example.ejerciciosdto_parte1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class Controller {

    @GetMapping("/{dia}/{mes}/{anio}")
    public ResponseEntity<Integer> getEdad(@PathVariable Integer dia,
                                          @PathVariable Integer mes,
                                          @PathVariable Integer anio){

        return ResponseEntity.ok(calcularEdad(dia,mes,anio));
    }

    private int calcularEdad (Integer dia, Integer mes, Integer anio){
        LocalDate fechaNacimiento = LocalDate.of(anio,mes,dia);
        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fechaNacimiento,fechaActual);
        return periodo.getYears();
    }
}
