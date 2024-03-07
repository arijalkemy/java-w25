package com.example.controllerW25.starwars.service;

import com.example.controllerW25.starwars.dto.PersonajeDTO;
import com.example.controllerW25.starwars.repository.PersonajeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonajeService {
    private final PersonajeRepository personajeRepository;
    public PersonajeService(){
        this.personajeRepository = new PersonajeRepository();
    }

    public List<PersonajeDTO> obtenerPersonajesPorNombre(String nombre){
        List<PersonajeDTO> personajesEncontrados =
                personajeRepository.getPersonajes().stream().filter(personaje -> personaje.getName().contains(nombre)).map(PersonajeDTO::fromPersonaje).toList();
        if(personajesEncontrados.isEmpty()){
            throw new RuntimeException("No se encontraron personajes con el nombre " + nombre);
        }
        return personajesEncontrados;
    }
}
