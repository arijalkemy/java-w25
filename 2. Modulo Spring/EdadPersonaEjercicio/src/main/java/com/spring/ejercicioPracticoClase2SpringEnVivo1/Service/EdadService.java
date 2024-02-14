package com.spring.ejercicioPracticoClase2SpringEnVivo1.Service;

import java.time.LocalDate;
import java.time.Period;

public class EdadService {

    public static Integer calcularEdad(int dia, int mes, int anio){
        LocalDate nacimiento = LocalDate.of(anio,mes,dia);
        LocalDate fechaActual = LocalDate.now();
        if(nacimiento.isAfter(fechaActual)){
            throw new IllegalArgumentException("La fecha de nacimiento es despues de la fecha actual.");
        }

        Period periodo = Period.between(nacimiento,fechaActual);

        return periodo.getYears();
    }
}
