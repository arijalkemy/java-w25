package com.vivo.calculoedad.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;


@RestController
@RequestMapping("/age")
public class AgeController {

    @GetMapping("/{day}/{month}/{year}")
    public String ageCalculator(@PathVariable int day, @PathVariable int month, @PathVariable int year) {
        LocalDate dateNow = LocalDate.now();
        LocalDate birthDate = LocalDate.of(year, month, day);

        if (birthDate.isAfter(dateNow)) {
            return "La fecha de nacimiento no puede ser mayor a la fecha actual";
        } else {
            return String.valueOf(Period.between(birthDate, dateNow).getYears());
        }
    }
}
