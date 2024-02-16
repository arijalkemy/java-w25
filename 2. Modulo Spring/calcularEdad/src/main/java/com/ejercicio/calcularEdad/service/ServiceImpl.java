package com.ejercicio.calcularEdad.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class ServiceImpl implements IService{
    @Override
    public int calculateAge(int day, int month, int year) {

        LocalDate localDate = LocalDate.now();

        LocalDate date = LocalDate.of(year, month, day);

        Period period = Period.between(date, localDate);

        return period.getYears();
    }
}
