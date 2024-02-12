package com.example.controllerW25.age;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class AgeController {
    @GetMapping("/age/{day}/{month}/{year}")
    public String age(@PathVariable int day, @PathVariable int month, @PathVariable int year) {
        try {
            return "Age: " + Period.between(LocalDate.of(year, month, day), LocalDate.now()).getYears();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

}
