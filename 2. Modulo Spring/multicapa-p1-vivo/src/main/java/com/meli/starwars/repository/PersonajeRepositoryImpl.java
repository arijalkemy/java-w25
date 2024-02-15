package com.meli.starwars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.starwars.entity.Personaje;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Repository
public class PersonajeRepositoryImpl implements PersonajeRepository{

    private List<Personaje> personajes = new ArrayList<>();

    public PersonajeRepositoryImpl() {
        loadPersonajes();
    }

    private void loadPersonajes(){
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<  Personaje>> typeRef = new TypeReference<>() {};

        try {
            personajes = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Personaje> findByName(String name) {
        return personajes.stream()
                .filter(x -> x.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }
}
