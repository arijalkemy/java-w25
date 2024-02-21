package com.bootcamp.StarWars.service;

import com.bootcamp.StarWars.dto.PersonajeDTO;
import com.bootcamp.StarWars.model.Personaje;
import com.bootcamp.StarWars.repository.PersonajeRepository;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
@Service
public class PersonajeService {
    @Autowired
    PersonajeRepository personajeRepository;
    public List<PersonajeDTO> buscarPorNombre(String name){
        ObjectMapper mapper = new ObjectMapper();
        List<Personaje> personajes = personajeRepository.getPersonajes();
        List<Personaje> personajesFiltrados = personajes.stream().filter(personaje -> personaje.getName().toUpperCase().contains(name.toUpperCase())).toList();
        return personajesFiltrados.stream().map(PersonajeDTO::new).toList();
    };

}
