package com.bootcamp.calculoEdad.model;

import java.time.LocalDate;
import java.time.Period;

public class CalculadorDeEdad {

    public static String calcular(int day, int month, int year){

        LocalDate birthDate = LocalDate.of(year, month, day);
        LocalDate currentDate = LocalDate.now();
        Period betweenPeriod = Period.between(birthDate, currentDate);

        if (!birthDate.isBefore(currentDate)) {
            return "Fecha no válida, ingresa una fecha anterior a la actual.";
        }

        return String.format(
                "Tienes %d años, %d meses y %d días.",
                betweenPeriod.getYears(),
                betweenPeriod.getMonths(),
                betweenPeriod.getDays()
        );
    }

}
