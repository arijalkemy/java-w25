package com.spring.ejercicioPracticoClase2SpringEnVivo1.controller;

import com.spring.ejercicioPracticoClase2SpringEnVivo1.Service.EdadService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EdadController {

    @GetMapping("/{dia}/{mes}/{anio}")
    public Integer calcularEdad(@PathVariable("dia") int dia, @PathVariable("mes") int mes, @PathVariable("anio") int anio){
        return EdadService.calcularEdad(dia, mes, anio);
    }
}
