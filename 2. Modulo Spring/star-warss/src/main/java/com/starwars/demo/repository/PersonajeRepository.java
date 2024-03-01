package com.starwars.demo.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.starwars.demo.entity.Personaje;
import lombok.Getter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Getter
@Repository
public class PersonajeRepository implements IPersonajeRepository{

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

