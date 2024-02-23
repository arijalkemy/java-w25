package com.bootcamp.apiedad;

import java.time.LocalDate;
import java.time.Period;

public class Edad {


    public static int calcularEdad(LocalDate fechaNacimiento){
        LocalDate fechaActual = LocalDate.now();
        Period edadCalculada = Period.between(fechaNacimiento, fechaActual);

        if (fechaActual.compareTo(fechaNacimiento) < 0){
            return 0;
        }
        return edadCalculada.getYears();
    }

}
