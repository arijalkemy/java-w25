package com.edad.edad.controller;

import org.springframework.cglib.core.Local;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

import java.time.Period;
import java.util.Date;

@RestController
public class Controller {

    // Probar haciendo Get a http://localhost:8080/20/05/1990

    @GetMapping(path = "/{day}/{month}/{year}")
    public int getEdad(@PathVariable int day,
                       @PathVariable int month,
                       @PathVariable int year){
        LocalDate fechaNacimiento = LocalDate.of(year, month, day);
        LocalDate fechaActual = LocalDate.now();

        if(LocalDate.now().isAfter(fechaNacimiento)){

        }

        Period periodo = Period.between(fechaNacimiento, fechaActual);
        int edad = periodo.getYears();

        if(edad<0){
            throw new IllegalArgumentException("El dato no puede ser nulo o vacío");
        }
        return edad;

    }


}
