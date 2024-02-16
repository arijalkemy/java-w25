package com.Starwars.StarwarsPersonajes.repository;

import com.Starwars.StarwarsPersonajes.entity.Personaje;
import com.fasterxml.jackson.databind.ObjectMapper;

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
        String rutaArchivo = "/Users/javmanzano/Documents/Bootcamp/Spring/StarwarsPersonajes/src/main/java/com/Starwars/StarwarsPersonajes/repository/starwars.json";
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            List<Map<String, Object>> datos = objectMapper.readValue(new File(rutaArchivo), List.class);

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
