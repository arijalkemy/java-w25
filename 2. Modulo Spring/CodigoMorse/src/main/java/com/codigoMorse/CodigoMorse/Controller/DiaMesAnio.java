package com.codigoMorse.CodigoMorse.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDate;
import java.time.Period;
@RestController
public class DiaMesAnio {
    @GetMapping("/diaMesAnio/{dia}/{mes}/{anio}")
    public ResponseEntity<String> calcularEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio) {
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
        Period periodo = Period.between(fechaNacimiento, fechaActual);
        int edad = periodo.getYears();
        String respuesta = "La edad es: " + edad + " años.";
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }
}
