package com.example.deportistas.repository;

import com.example.deportistas.models.Persona;

public class PersonaRepository {

    List<Persona> personas = new ArrayList<>(new Persona("Juan", "Perez", "Futbol", 25), new Persona("Maria", "Lopez", "Baloncesto", 30), new Persona("Pedro", "Gomez", "Natacion", 22), new Persona("Ana", "Garcia", "Atletismo", 28), new Persona("Luis", "Martinez", "Ciclismo", 35));
}
