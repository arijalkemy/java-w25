package com.bootcamp.deportistas.repository;

import com.bootcamp.deportistas.entity.Deporte;
import com.bootcamp.deportistas.entity.Persona;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonaRepository {
    List<Persona> listaPersonas = List.of(
            new Persona("Juan", "Gomez", 31, List.of(new Deporte("Basketball", "Basico"))),
            new Persona("Lucia", "Arenas", 19, List.of(new Deporte("Volleyball", "Avanzado"))),
            new Persona("Martin", "Valencia", 26, List.of(new Deporte("Basketball", "Intermedio"))),
            new Persona("Ana", "Barco", 32, List.of(new Deporte("Futbol", "Avanzado"))),
            new Persona("Isabel", "Cardenas", 21, List.of(new Deporte("Natacion", "Intermedio")))
    );

    public List<Persona> getListaPersonas() {
        return listaPersonas;
    }
}
