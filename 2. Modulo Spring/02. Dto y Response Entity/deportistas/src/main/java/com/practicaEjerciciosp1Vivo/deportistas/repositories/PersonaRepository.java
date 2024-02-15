package com.practicaEjerciciosp1Vivo.deportistas.repositories;

import com.practicaEjerciciosp1Vivo.deportistas.model.Persona;

import java.util.ArrayList;
import java.util.List;

public class PersonaRepository {
    List<Persona> personas = new ArrayList<>();

    public PersonaRepository() {
        Persona persona1 = new Persona("Luca", "Beltramini", 29);
        Persona persona2 = new Persona("Franco", "Pizzini", 21);
        Persona persona3 = new Persona("German", "Galvez", 33);
        this.personas.add(persona1);
        this.personas.add(persona2);
        this.personas.add(persona3);
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void addPersona(Persona persona){
        this.personas.add(persona);
    }
}
