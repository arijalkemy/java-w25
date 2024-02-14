package com.bootcamp.clase9feb.starWars.repositories;

import com.bootcamp.clase9feb.starWars.entities.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonajeRepositoryImp implements IPersonajeRepository{

    List<Personaje> personajes;
    public PersonajeRepositoryImp(){
        this.personajes = new ArrayList<>();
        loadJson();
    }
    private void loadJson () {
        ObjectMapper mapper = new ObjectMapper();
        File jsonFile = null; // objeto de file declarado
        try {
            jsonFile = ResourceUtils.getFile("classpath:starwars.json"); // abre archivo
            personajes = mapper.readValue(jsonFile, new TypeReference<List<Personaje>>() {});
            // transforma lo q hay en el primero al tipo del segundo
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Personaje> getByName(String name) {
        List<Personaje> personajeBuscado =  personajes.stream().filter(p -> p.getName().equals(name)).toList();
        if(personajeBuscado.isEmpty()) throw new RuntimeException("No se encontro el personaje");
        return personajeBuscado;
    }
}
