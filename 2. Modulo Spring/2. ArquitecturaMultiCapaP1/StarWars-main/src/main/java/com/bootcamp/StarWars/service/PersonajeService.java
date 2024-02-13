package com.bootcamp.StarWars.service;

import com.bootcamp.StarWars.dto.PersonajeDTO;
import com.bootcamp.StarWars.model.Personaje;
import com.bootcamp.StarWars.repository.IPersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PersonajeService {
    @Autowired
    IPersonajeRepository personajeRepositoryImp;
    public List<PersonajeDTO> buscarPorNombre(String name){
        List<Personaje> personajes = personajeRepositoryImp.getPersonajes();
        List<Personaje> personajesFiltrados = personajes.stream().filter(personaje -> personaje.getName().toUpperCase().contains(name.toUpperCase())).toList();
        return personajesFiltrados.stream().map(PersonajeDTO::new).toList();
    };

}
