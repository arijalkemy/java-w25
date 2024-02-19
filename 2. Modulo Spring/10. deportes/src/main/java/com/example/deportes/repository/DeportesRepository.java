package com.example.deportes.repository;

import com.example.deportes.Deporte;
import com.example.deportes.Persona;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeportesRepository {

    public static List<Deporte> deportes = new ArrayList<>(Arrays.asList(
            new Deporte("Fútbol", "Básico"),
            new Deporte("Tenis", "Avanzado"),
            new Deporte("Rugby", "Básico"),
            new Deporte("Voley", "Básico"),
            new Deporte("Basket", "Básico"),
            new Deporte("Handbol", "Intermedio"),
            new Deporte("Natación", "Intermedio")
    ));

    public static List<Persona> personas = Arrays.asList(
            new Persona("Fulano", "Fulanez", 19, new ArrayList<>(Arrays.asList(new Deporte("Fútbol", "Básico"),
                    new Deporte("Tenis", "Avanzado")))),
            new Persona("Oscar", "Fulanez", 19, new ArrayList<>(Arrays.asList(new Deporte("Voley", "Básico"),
                    new Deporte("Tenis", "Avanzado")))),
            new Persona("Juan", "Fulanez", 19, new ArrayList<>(Arrays.asList(new Deporte("Natacion", "Básico"),
                    new Deporte("Tenis", "Avanzado"))))

            );
}