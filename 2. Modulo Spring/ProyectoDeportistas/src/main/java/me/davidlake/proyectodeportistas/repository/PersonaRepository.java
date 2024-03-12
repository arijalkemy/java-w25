package me.davidlake.proyectodeportistas.repository;

import me.davidlake.proyectodeportistas.model.Persona;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonaRepository {
    public static final List<Persona> personas = List.of(
            new Persona("Samuel","Villegas", 20, DeporteRepository.deportes.get(0)),
            new Persona("Julian","Giraldo", 25, DeporteRepository.deportes.get(1)),
            new Persona("David","Cardona", 30, DeporteRepository.deportes.get(2))
    );

    public List<Persona> get(){
        return personas;
    }
}
