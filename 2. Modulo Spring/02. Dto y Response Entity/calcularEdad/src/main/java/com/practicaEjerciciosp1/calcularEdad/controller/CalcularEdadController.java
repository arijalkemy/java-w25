package com.practicaEjerciciosp1.calcularEdad.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class CalcularEdadController {

    @GetMapping("/edad/{day}/{month}/{year}")
    public int calcularEdad (@PathVariable int day, @PathVariable int month, @PathVariable int year){

        int yearA = LocalDateTime.now().getYear();
        int monthA = LocalDateTime.now().getMonthValue();
        int dayA = LocalDateTime.now().getDayOfMonth();

        int difYears = yearA - year;
        if ( (monthA < month) || (monthA == month && dayA < day) ) return difYears - 1;
        return difYears;
    }
}
