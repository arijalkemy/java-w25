package main.model;

import java.time.LocalDate;
import java.util.Date;

public class Persona {
    public static int getEdad(int day, int month, int year) {

        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaNacimiento = LocalDate.of(year,month,day);

        int edad = fechaActual.getYear() - fechaNacimiento.getYear();
        if(fechaActual.isBefore(fechaNacimiento))
        {
            throw new RuntimeException("La fecha actual no puede ser mayor a la fecha de nacimiento");
        }
        boolean mesActualMenor = fechaActual.getMonthValue() < fechaNacimiento.getMonthValue();
        boolean mesIgual_diaActualMenor = fechaActual.getMonthValue() == fechaNacimiento.getMonthValue() &&
                fechaActual.getDayOfMonth() < fechaNacimiento.getDayOfMonth();

        if (mesActualMenor || mesIgual_diaActualMenor)
            edad--;

        return edad;
    }
}
