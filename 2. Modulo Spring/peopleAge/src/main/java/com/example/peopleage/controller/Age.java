package com.example.peopleage.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class Age {

    @GetMapping("/{d}/{m}/{a}")
    public String getAge(@PathVariable int d, @PathVariable int m, @PathVariable int a) {
        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(a, m, d);
        Integer age = today.getYear() - birthday.getYear();
        if (birthday.isAfter(today)) {
            throw new RuntimeException("Invalid date");
//            return "Invalid date";
        }
        return ((Integer) Period.between(birthday, today).getYears()).toString();
    }
}
