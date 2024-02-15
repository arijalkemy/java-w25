package main.controller;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")

public class Controller {
    
    @GetMapping("/obtenerEdad/{dia}/{mes}/{anyo}")
    public String obtenerEdad(@PathVariable Integer dia, @PathVariable Integer mes, @PathVariable Integer anyo) {
        LocalDate fechaNacimiento = LocalDate.of(anyo, mes, dia);
        LocalDate fechaActual = LocalDate.now();
        Period peridoTiempo = Period.between(fechaNacimiento, fechaActual);
        if (fechaNacimiento.compareTo(fechaActual) > 0) {
            return "La persona aun no nacio";
        }
        return "La edad de la persona es: " + peridoTiempo.getYears() + " años.";
    }

}
