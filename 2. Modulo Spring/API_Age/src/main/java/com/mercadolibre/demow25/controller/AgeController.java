package com.mercadolibre.demow25.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.YEARS;


public class AgeController {

    public long getAger(@PathVariable String day, @PathVariable String month, @PathVariable String year){
        return  calculateAge(LocalDate.of(Integer.valueOf(year),Integer.valueOf(month),Integer.valueOf(day)));
    }

    private long calculateAge(LocalDate birthday){
        if(birthday.isBefore(LocalDate.now())){
            return YEARS.between(birthday,LocalDate.now());
        }else {
            return 0;
        }
    }
}
