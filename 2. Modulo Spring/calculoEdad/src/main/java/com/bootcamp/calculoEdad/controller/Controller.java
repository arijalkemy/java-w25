package com.bootcamp.calculoEdad.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.calculoEdad.model.*;


@RestController
public class Controller {
    @GetMapping(path = "/{day}/{month}/{year}")
    public String calcularEdad(@PathVariable int day, @PathVariable int month, @PathVariable int year) {
        return CalculadorDeEdad.calcular(day, month, year);
    }
}