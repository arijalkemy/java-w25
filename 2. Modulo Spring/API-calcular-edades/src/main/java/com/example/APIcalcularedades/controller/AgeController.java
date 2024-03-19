package com.example.APIcalcularedades.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class AgeController {

    @GetMapping("/age/{day}/{month}/{year}")
    public String calcularEdad(@PathVariable int day,
                               @PathVariable int month,
                               @PathVariable int year){
        if((year > 2024) && (month > 2) && (day > 8)){
            return "Esta fecha no es válida.\n ";
        }else{
            try{
                return "Edad: " + Period.between(LocalDate.of(year, month, day), LocalDate.now()).getYears() + " años";
            } catch (Exception e) {
                return "Esta fecha no es válida.\n " + e.getMessage();
            }
        }
    }

}
