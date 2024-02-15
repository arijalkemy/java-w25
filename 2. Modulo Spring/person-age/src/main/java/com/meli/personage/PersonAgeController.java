package com.meli.personage;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class PersonAgeController {
    @GetMapping("/{day}/{month}/{year}")
    public String getAge(@PathVariable int day, @PathVariable int month, @PathVariable int year){
        LocalDate bornDate = LocalDate.of(year, month, day);
        LocalDate currentDate = LocalDate.now();
        int age = Period.between(bornDate, currentDate).getYears();
        return "La edad de la persona es: " + age + " años.";
    }

}
