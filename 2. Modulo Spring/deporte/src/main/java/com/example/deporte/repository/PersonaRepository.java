package com.example.deporte.repository;

import com.example.deporte.model.Persona;
import lombok.Getter;

import java.util.ArrayList;

public class PersonaRepository {
    @Getter
    private static ArrayList<Persona> personas = new ArrayList<>();

    public static void addPersona(Persona persona) {
        personas.add(persona);
    }

    public static Persona getPersona(String nombre) {
        for (Persona persona : personas) {
            if (persona.getNombre().equals(nombre)) {
                return persona;
            }
        }
        return null;
    }
}
