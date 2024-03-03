package CalcularEdad.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
@RequestMapping(path="/edad")
public class EdadController {

    @GetMapping(path="/{dia}/{mes}/{anio}")
    public Integer getEdad(@PathVariable Integer dia,
                            @PathVariable Integer mes,
                            @PathVariable Integer anio){
        LocalDate date = LocalDate.now();
        LocalDate userdate = LocalDate.of(anio, mes, dia);
        Period userYears = Period.between(userdate, date);
        if(userYears.getYears() <= 0){
            return -1;
        }
        return userYears.getYears();
    }
}
