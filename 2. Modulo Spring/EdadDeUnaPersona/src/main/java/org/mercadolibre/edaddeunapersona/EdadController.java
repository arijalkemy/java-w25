package org.mercadolibre.edaddeunapersona;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@RestController
public class EdadController {
    @GetMapping("/{fecha}")
    public String getEdad (@RequestParam String fecha) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(fecha, formatter);
        if (date.isAfter(LocalDate.now())) return "Fecha invalida";
        return String.valueOf(Period.between(date, LocalDate.now()).getYears());
    }
}
