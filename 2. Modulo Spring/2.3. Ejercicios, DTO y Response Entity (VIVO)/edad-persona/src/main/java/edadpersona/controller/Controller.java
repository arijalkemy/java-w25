package edadpersona.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class Controller {

    @GetMapping("/{dia}/{mes}/{anno}")
    public int getEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int anno) {
        LocalDate fechaNacimiento = LocalDate.of(anno, mes, dia);
        LocalDate fechaActual = LocalDate.now();
        if (fechaNacimiento.isAfter(fechaActual)) {
            throw new RuntimeException("La fecha de nacimiento no puede ser posterior a la fecha actual.");
        }
        Period periodo = Period.between(fechaNacimiento, fechaActual);
        return periodo.getYears();
    }
}