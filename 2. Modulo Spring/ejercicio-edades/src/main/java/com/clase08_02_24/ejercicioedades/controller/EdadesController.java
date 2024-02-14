package com.clase08_02_24.ejercicioedades.controller;

import com.clase08_02_24.ejercicioedades.service.EdadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EdadesController {
    @Autowired
    EdadService edadService = new EdadService();


    @GetMapping(path = "/{dia}/{mes}/{anio}")
    public Integer calculadoraDeEdad(@PathVariable Integer dia,@PathVariable Integer mes,@PathVariable Integer anio){
        return edadService.calcularEdad(dia,mes,anio);
    }
}
