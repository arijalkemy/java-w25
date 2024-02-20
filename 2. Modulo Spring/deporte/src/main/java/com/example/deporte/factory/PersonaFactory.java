package com.example.deporte.factory;

import com.example.deporte.model.Persona;
import com.example.deporte.repository.PersonaRepository;

public class PersonaFactory {

    public static void createPersonas() {
        PersonaRepository.addPersona(new Persona("Juan", "Perez", 30));
        PersonaRepository.addPersona(new Persona("Pedro", "Gomez", 40));
        PersonaRepository.addPersona(new Persona("Maria", "Lopez", 50));
        PersonaRepository.addPersona(new Persona("Jose", "Martinez", 60));
    }
}
