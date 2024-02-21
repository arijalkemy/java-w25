package com.sfritz.starwars.repositories;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sfritz.starwars.entities.Personaje;

@Repository
public class PersonajeRepositoryImpl implements PersonajeRepository{

    private List<Personaje> personajes;

    public PersonajeRepositoryImpl(){
        //leer JSON desde resources
        loadJson();
    }

    @Override
    public List<Personaje> getPersonajeByName(String name) {
        //Hacer la busqueda en el Json
        for(Personaje p:this.personajes){
            System.out.println(p.getClass());
            System.out.println(p.toString());
        }
        return new ArrayList<Personaje>();
    }
    
    private void loadJson(){
        ObjectMapper objectMapper = new ObjectMapper();
        File jsonFile = null;
        try {
            // Lee el archivo JSON
            jsonFile = ResourceUtils.getFile("classpath:starwars.json");
            this.personajes = objectMapper.readValue(jsonFile, new TypeReference<List<Personaje>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
