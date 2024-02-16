package com.bootcamp.ejercicio_edad_persona.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
@RestController
public class Controller {
    @GetMapping("/{day}/{month}/{year}")
    public long calculate(@PathVariable int day, @PathVariable int month, @PathVariable int year) throws Exception {
        if (day < 1 || day > 31)
            throw new RuntimeException("Debes ingresar un día válido");
        if (month < 1 || month > 12)
            throw new RuntimeException("Debes ingresar un mes válido");
        LocalDate today = LocalDate.now();
        LocalDate birthdate = LocalDate.of(year, month, day);
        if (birthdate.isAfter(today))
            throw new RuntimeException("Debes ingresar una fecha anterior a la actual");

        return ChronoUnit.YEARS.between(birthdate, today);
    }
}
