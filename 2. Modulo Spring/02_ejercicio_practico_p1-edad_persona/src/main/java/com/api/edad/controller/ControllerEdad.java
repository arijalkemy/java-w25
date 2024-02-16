package com.api.edad.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Calendar;
import java.util.GregorianCalendar;


@RestController
public class ControllerEdad {
    
    @GetMapping("/{dia}/{mes}/{anio}")
    public ResponseEntity<Integer> getMethodName(
        @PathVariable int dia,
        @PathVariable int mes,
        @PathVariable int anio
    ) {
        Calendar fechaNacimiento = new GregorianCalendar(anio, mes - 1, dia);
        Calendar fechaHoy = new GregorianCalendar();

        if (fechaHoy.compareTo(fechaNacimiento) < 0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        int diff = fechaHoy.get(Calendar.YEAR) - fechaNacimiento.get(Calendar.YEAR);

        if (fechaNacimiento.get(Calendar.MONTH) > fechaHoy.get(Calendar.MONTH) || 
            (
                fechaNacimiento.get(Calendar.MONTH) == fechaHoy.get(Calendar.MONTH) &&
                fechaNacimiento.get(Calendar.DATE) > fechaHoy.get(Calendar.DATE)
            )) {
            diff--;
        }
        return ResponseEntity.ok().body(diff);
    }
}
