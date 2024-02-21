package com.edad.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class EdadController {
    @GetMapping("{dia}/{mes}/{anio}")
    public int getEdad(@PathVariable int dia,
                       @PathVariable int mes,
                       @PathVariable int anio){
        LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
        LocalDate fechaActual = LocalDate.now();

        // Calculo de la edad
        Period periodo = Period.between(fechaNacimiento, fechaActual);
        return periodo.getYears();
    }
}
