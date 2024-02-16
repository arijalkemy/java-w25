package com.bootcamp.StarWars.repository;

import com.bootcamp.StarWars.entity.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import org.springframework.stereotype.Repository;

import java.io.FileNotFoundException;
import java.util.List;
import org.springframework.util.ResourceUtils;

@Repository
public class PersonajeRepositorioImp implements IPersonajeRepositorio {

    private List<Personaje> personajes;

    public PersonajeRepositorioImp() throws FileNotFoundException {
        this.personajes = cargarLista();
    }

    private List<Personaje> cargarLista() {
        ObjectMapper mapper = new ObjectMapper();
        File jsonFile = null;
        try {
            jsonFile = ResourceUtils.getFile("classpath:starwars.json");
            return mapper.readValue(jsonFile, new TypeReference<List<Personaje>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Personaje> getPersonajes() {
        return this.personajes;
    }
}
