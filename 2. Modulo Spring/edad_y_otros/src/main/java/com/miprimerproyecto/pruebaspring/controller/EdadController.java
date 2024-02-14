package com.miprimerproyecto.pruebaspring.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;

@RestController
public class EdadController {


    @GetMapping("/getAge/{dia}/{mes}/{anio}")
    public Integer getAge(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio){

            LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);

            LocalDate fechaActual = LocalDate.now();

            int edad = Period.between(fechaNacimiento, fechaActual).getYears();

            if(edad<0){
                throw new DateTimeException("La fecha de nacimiento ingresada es inválida");
            }

            return edad;



    }


}
