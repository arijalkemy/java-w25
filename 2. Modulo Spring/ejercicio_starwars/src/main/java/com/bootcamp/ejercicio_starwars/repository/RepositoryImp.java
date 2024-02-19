package com.bootcamp.ejercicio_starwars.repository;

import com.bootcamp.ejercicio_starwars.dto.PersonajeDTO;
import com.bootcamp.ejercicio_starwars.entity.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RepositoryImp implements IRepository{
    List<Personaje> personajes = new ArrayList<>();

    public RepositoryImp() {
        loadList();
    }

    @Override
    public List<Personaje> getAll() {
        return personajes;
    }

    @Override
    public List<Personaje> getCharactersByName(String name) {
        return personajes.stream()
                .filter(personaje -> personaje.getName().contains(name))
                .collect(Collectors.toList());
    }

    private void loadList() {
        ObjectMapper mapper = new ObjectMapper();
        File jsonFile = null;
        try {
            jsonFile = ResourceUtils.getFile("classpath:starwars.json");
            TypeReference<List<Personaje>> tipoPersonaje = new TypeReference<List<Personaje>>() {};
            this.personajes = mapper.readValue(jsonFile, tipoPersonaje);
        } catch (IOException e) {
            System.out.println("No existe el archivo. " + e.getMessage());
        }
    }
}
