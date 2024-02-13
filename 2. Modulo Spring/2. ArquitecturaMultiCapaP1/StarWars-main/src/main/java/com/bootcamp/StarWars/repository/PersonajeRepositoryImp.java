package com.bootcamp.StarWars.repository;

import com.bootcamp.StarWars.model.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonajeRepositoryImp implements IPersonajeRepository {

    public List<Personaje> getPersonajes(){
        List<Personaje> personajes = new ArrayList<>();
        try{
        byte[] jsonData = Files.readAllBytes(Paths.get("starwars.json"));
        ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Personaje>> typeReference = new TypeReference<>(){};
            personajes = mapper.readValue(jsonData, typeReference);
    } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return personajes;
    }
}
