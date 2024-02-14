package com.clase08_02_24.ejercicioedades.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class EdadService {
    public Integer calcularEdad(Integer dia, Integer mes, Integer anio){

        LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
        LocalDate fechaActual = LocalDate.now();

        Period periodo = Period.between(fechaNacimiento, fechaActual);

        return periodo.getYears();
    }
}
