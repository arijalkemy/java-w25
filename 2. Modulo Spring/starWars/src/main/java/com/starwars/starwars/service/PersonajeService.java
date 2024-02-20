package com.starwars.starwars.service;

import com.starwars.starwars.dto.PersonajeDTO;
import com.starwars.starwars.entity.Personaje;
import com.starwars.starwars.repository.PersonajeRepository;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class PersonajeService {
    private final PersonajeRepository personajeRepository;

    public PersonajeService() {
        this.personajeRepository = new PersonajeRepository();
    }

    public ArrayList<PersonajeDTO> getPersonajeByName(String name) {
        ArrayList<Personaje> personajes = this.personajeRepository.getPersonajeByName(name);
        ArrayList<PersonajeDTO> personajesDTO = new ArrayList<>();
        for (Personaje personaje : personajes) {
            personajesDTO.add(new PersonajeDTO(personaje.getName(), personaje.getHeight(), personaje.getMass(), personaje.getGender(), personaje.getHomeworld(), personaje.getSpecies()));
        }
        return personajesDTO;
    }
}
