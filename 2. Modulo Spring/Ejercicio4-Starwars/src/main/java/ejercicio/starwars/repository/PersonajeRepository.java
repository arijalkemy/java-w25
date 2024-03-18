package ejercicio.starwars.repository;

import ejercicio.starwars.dto.PersonajeDTO;
import ejercicio.starwars.entity.Personaje;

import java.util.List;

public interface PersonajeRepository {
    List<Personaje> mostrarPersonajes();
}
