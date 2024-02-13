package com.Starwars.StarwarsPersonajes.repository;

import com.Starwars.StarwarsPersonajes.entity.Personaje;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class PersonajeRepository {

    private List<Personaje> personajes = new ArrayList<>();

    public PersonajeRepository() {
        setPersonajesForJSON();
    }

    public List<Personaje> getPersonajes() {
        return personajes;
    }

    public void setPersonajesForJSON(){
        String rutaArchivo = "src/main/resources/starwars.json";
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            List<Map<String, Object>> datos = objectMapper.readValue(new File(rutaArchivo), List.class);

            for (Map<String, Object> dato : datos) {
                Personaje personaje = new Personaje();
                personaje.setName((String) dato.get("name"));
                personaje.setHeight(setStringToInteger(dato.get("height").toString()));
                personaje.setMass(setStringToInteger(dato.get("mass").toString()));
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

    private Integer setStringToInteger (String dataString){
        if (dataString != null && dataString.matches("[0-9]+")){
            return Integer.parseInt(dataString);
        }
        return null;
    }
}
