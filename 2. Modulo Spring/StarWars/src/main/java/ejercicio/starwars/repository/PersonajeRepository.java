package ejercicio.starwars.repository;

import ejercicio.starwars.dto.PersonajeDTO;

import java.util.List;

public interface PersonajeRepository {
    List<PersonajeDTO> mostrarPersonajes(String personaje);
}
