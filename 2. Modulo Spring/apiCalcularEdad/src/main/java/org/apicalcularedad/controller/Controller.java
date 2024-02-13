package org.apicalcularedad.controller;

import org.springframework.cglib.core.Local;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

import java.time.Period;
import java.util.Date;

@RestController
public class Controller {

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
            //return new ResponseEntity<>("Fecha invalida", HttpStatus.BAD_REQUEST);
            throw new IllegalArgumentException("Fecha invalida");
        }
        return edad;

    }
}