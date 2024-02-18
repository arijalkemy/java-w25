package org.mercadolibre.deportistas.repository;

import org.mercadolibre.deportistas.model.Persona;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonasRepository {
    public static final List<Persona> personas = List.of(
            new Persona("Juan","Fangio", 33, DeportesRepository.deportes.get(1)),
            new Persona("Gaston","Gaudio", 28, DeportesRepository.deportes.get(1)),
            new Persona("Emanuel","Ginobili", 30, DeportesRepository.deportes.get(2))
    );

    public List<Persona> getAll() {
        return personas;
    }
}