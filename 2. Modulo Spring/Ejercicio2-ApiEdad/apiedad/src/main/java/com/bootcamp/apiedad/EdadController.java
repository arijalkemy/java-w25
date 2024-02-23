package com.bootcamp.apiedad;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class EdadController {

    @GetMapping("/edad/{dia}/{mes}/{anio}")
    public int edad(@PathVariable int dia,
                    @PathVariable int mes,
                    @PathVariable int anio){
        LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
        return Edad.calcularEdad(fechaNacimiento);
    }
}
