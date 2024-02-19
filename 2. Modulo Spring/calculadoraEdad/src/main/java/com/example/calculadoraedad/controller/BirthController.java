package com.example.calculadoraedad.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
    @RequestMapping("/birthdate")
    public class BirthController {
        @GetMapping("/getyear/{day}/{month}/{year}")
        public String getAge(@PathVariable int day, @PathVariable int month, @PathVariable int year){
            LocalDate currentDate = LocalDate.now();
            LocalDate birthDate = LocalDate.of(year,month,day);
            return "Tienes " + Period.between(birthDate,currentDate).getYears() +" años";
        }
    }

