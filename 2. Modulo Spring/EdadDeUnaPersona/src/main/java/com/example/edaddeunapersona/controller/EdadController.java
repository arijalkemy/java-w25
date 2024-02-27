package com.example.edaddeunapersona.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
@RequestMapping("/edad")
public class EdadController {
    @GetMapping("/{day}/{month}/{year}")
    public int calcularEdad(@PathVariable int day, @PathVariable int month, @PathVariable int year) {
        return ageCalculator(day, month, year);
    }

    private int ageCalculator(int day, int month, int year) {
        LocalDate birthDate = LocalDate.of(year, month, day);
        LocalDate currentDate = LocalDate.now();
        return Period.between(birthDate, currentDate).getYears();
    }
}