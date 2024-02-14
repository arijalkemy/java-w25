package com.bootcamp.clase9feb.starWars.services;

import com.bootcamp.clase9feb.starWars.dto.response.PersonajeDTO;
import com.bootcamp.clase9feb.starWars.entities.Personaje;
import com.bootcamp.clase9feb.starWars.repositories.IPersonajeRepository;
import com.bootcamp.clase9feb.starWars.repositories.PersonajeRepositoryImp;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonajeServiceImp implements IPersonajeService{
    IPersonajeRepository repository;

    public PersonajeServiceImp(PersonajeRepositoryImp repository) {
        this.repository = repository;
    }
    @Override
    public List<PersonajeDTO> getByName(String name) {
        ObjectMapper mapper = new ObjectMapper();
        List<Personaje> personajes = repository.getByName(name);
        // Forma 1: Masiva
        List<PersonajeDTO> personajesDTOS = mapper.convertValue(personajes, new TypeReference<List<PersonajeDTO>>() {});
        // Forma 2: uno por uno
        // personajes.forEach(p -> { personajesDTOS.add(mapper.convertValue(p, PersonajeDTO.class));});
        // mapper.convertValue(personaje, PersonajeDTO.class); --> Para convertir clase de dominio a DTO
        return personajesDTOS;
    }
}
