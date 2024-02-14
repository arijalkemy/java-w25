package com.springlh.ejercicios0802.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
@RequestMapping("/ejercicios")
public class EjerciciosController {

    //SALA 8
    @GetMapping("/edad/{dia}/{mes}/{anio}")
    public ResponseEntity<String> edad(@PathVariable String dia,
                                       @PathVariable String mes,
                                       @PathVariable String anio) {

        LocalDate fechaNac = LocalDate.of(Integer.parseInt(anio), Integer.parseInt(mes), Integer.parseInt(dia));
        LocalDate fechaActual = LocalDate.now();

        if (fechaNac.getYear() > fechaActual.getYear()) {
            return ResponseEntity.badRequest().body("El año ingresado no es válido.");
        }

        Integer edad = Period.between(fechaNac, fechaActual).getYears();

        return ResponseEntity.ok("La edad es: " + edad);
    }
}
