package ejercicio.edad.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Date;

@RestController
public class
EdadController {
    @GetMapping("/{day}/{month}/{year}")
    public int Edad(@PathVariable int day, @PathVariable int month, @PathVariable int year) {

        return calcularEdad(day, month, year);
    }

    public int calcularEdad(int day, int month, int year) {
    int edadFinalParcial = 2024-year-1;
    LocalDate fecha = LocalDate.now();
    if (month>fecha.getMonthValue()){
        edadFinalParcial++;
    } else if (month == fecha.getMonthValue() && day>=fecha.getDayOfMonth()){
            edadFinalParcial++;
        }
    return edadFinalParcial;
    }
}