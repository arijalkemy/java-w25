package com.ejercicio.calcularEdad.controller;

import com.ejercicio.calcularEdad.service.IService;
import com.ejercicio.calcularEdad.service.ServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class Controller {

    private final IService service;

    public Controller(ServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/{day}/{month}/{year}")
    public ResponseEntity<Integer> getAge(@PathVariable Integer day, @PathVariable Integer month, @PathVariable Integer year){


        return new ResponseEntity<>(service.calculateAge(day,month, year), HttpStatus.OK);
    }
}
