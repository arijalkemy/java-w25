package com.example.covid.repository;

import com.example.covid.models.GravedadEnum;
import com.example.covid.models.Persona;
import com.example.covid.models.Sintoma;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CovidRepository {

    private static List<Sintoma> sintomas = new ArrayList<>(Arrays.asList(
            new Sintoma("123", "Fiebre", GravedadEnum.MODERADO),
            new Sintoma("134", "Tos seca", GravedadEnum.MODERADO),
            new Sintoma("456", "Hipoxia", GravedadEnum.GRAVE)));

    private static List<Persona> personas = new ArrayList<>(Arrays.asList(
            new Persona(1, "Juan", "Jaramillo", 30, new ArrayList<>(Arrays.asList(sintomas.stream().findFirst().get()))),
            new Persona(2, "Luisa", "Polanco", 90, new ArrayList<>(new ArrayList<>(sintomas))))
    );

    public static List<Sintoma> getAllSintomas(){
        return sintomas;
    }

    public static Optional<Sintoma> getSintomaByName(String name){
        return sintomas.stream().filter(s -> s.getNombre().equals(name)).findFirst();
    }

    public static List<Persona> getPersonasEnRiesgo(){
        return personas.stream().filter(p -> p.getEdad() > 60 && p.getSintomas().size() > 1).toList();
    }
}
