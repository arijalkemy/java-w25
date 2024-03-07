package com.Starwars.StarwarsPersonajes.repository;

import com.Starwars.StarwarsPersonajes.entity.Personaje;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PersonajeRepository {

    private List<Personaje> personajes = new ArrayList<>();

    public PersonajeRepository() {
        setPersonajesForJSON();
    }

    public List<Personaje> getPersonajes() {
        return personajes;
    }

    public void setPersonajesForJSON(){
        String rutaArchivo = "classpath:starwars.json";
        ObjectMapper objectMapper = new ObjectMapper();
        File file;
        try {
            file = ResourceUtils.getFile(rutaArchivo);
            List<Map<String, Object>> datos = objectMapper.readValue(file, List.class);

            for (Map<String, Object> dato : datos) {
                Personaje personaje = new Personaje();
                personaje.setName((String) dato.get("name"));
                personaje.setHeight((String) dato.get("height").toString());
                personaje.setMass((String) dato.get("mass").toString());
                personaje.setHairColor((String) dato.get("hair_color"));
                personaje.setSkinColor((String) dato.get("skin_color"));
                personaje.setEyeColor((String) dato.get("eye_color"));
                personaje.setBirthYear((String) dato.get("birth_year"));
                personaje.setGender((String) dato.get("gender"));
                personaje.setHomeworld((String) dato.get("homeworld"));
                personaje.setSpecies((String) dato.get("species"));

                personajes.add(personaje);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
