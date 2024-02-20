package com.starwars.starwars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.starwars.starwars.dto.PersonajeReadDTO;
import com.starwars.starwars.entity.Personaje;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PersonajeRepository {
    private final List<Personaje> database;

    public PersonajeRepository() {
        database = new ArrayList<>();

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            List<PersonajeReadDTO> personajeReadDTOS = objectMapper.readValue(new File("/Users/jtoromejia/IdeaProjects/starWars/src/main/resources/starwars.json"), new TypeReference<List<PersonajeReadDTO>>() {});
            for (PersonajeReadDTO personajeReadDTO : personajeReadDTOS) {
                if (personajeReadDTO.getMass().equals("NA")) {
                    personajeReadDTO.setMass("0");
                }
                if (personajeReadDTO.getHeight().equals("NA")) {
                    personajeReadDTO.setHeight("0");
                }
                try {
                    Integer.parseInt(personajeReadDTO.getMass());
                } catch (NumberFormatException e) {
                    personajeReadDTO.setMass("0");
                }
                try {
                    Integer.parseInt(personajeReadDTO.getHeight());
                } catch (NumberFormatException e) {
                    personajeReadDTO.setHeight("0");
                }
                this.database.add(new Personaje(personajeReadDTO.getName(), Integer.parseInt(personajeReadDTO.getHeight()), Integer.parseInt(personajeReadDTO.getMass()), personajeReadDTO.getHairColor(), personajeReadDTO.getSkinColor(), personajeReadDTO.getEyeColor(), personajeReadDTO.getBirthYear(), personajeReadDTO.getGender(), personajeReadDTO.getHomeworld(), personajeReadDTO.getSpecies()));
            }
        } catch (IOException e) {
            System.out.println("Error en la lectura del archivo json");
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Personaje> getPersonajeByName(String name) {
        ArrayList<Personaje> personajes = this.database.stream().filter(per -> per.getName().contains(name)).collect(Collectors.toCollection(ArrayList::new));;
        return personajes;
    }
}
