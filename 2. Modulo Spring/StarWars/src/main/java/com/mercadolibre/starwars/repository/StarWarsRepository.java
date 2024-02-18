package com.mercadolibre.starwars.repository;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.starwars.entity.Personaje;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;

@Repository
public class StarWarsRepository {

    List<Personaje> personajeList = new ArrayList<>();

    public StarWarsRepository () {

        ObjectMapper mapper = new ObjectMapper();
        try {
            personajeList = mapper.readValue(
                    new File("src/main/resources/personajes.json"),
                    new TypeReference<List<Personaje>>() {
                    });
        }
        catch(IOException err) {
            System.out.println(err.getMessage());
        }
    }

    public List<Personaje> getPersonajes(){
        return personajeList;
    }
}
