package com.example.personajesdestarwars.repositories;

import com.example.personajesdestarwars.dto.PersonajeDTO;
import com.example.personajesdestarwars.entity.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonajeRepositpryImp implements IPersonajeRepository {
    private List<Personaje> personajes;

    public PersonajeRepositpryImp() {
        personajes = loadPersonajes();
    }

    @Override
    public List<Personaje> findAllByNameContains(String query) {
        List<Personaje> personajesFiltrados = personajes.stream()
                .filter(personaje -> personaje.getName().contains(query))
                .collect(Collectors.toList());
        return personajesFiltrados;
    }

    private List<Personaje> loadPersonajes() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Personaje>> typeRef = new TypeReference<>() {};
        List<Personaje> characters = null;
        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
    }
}
