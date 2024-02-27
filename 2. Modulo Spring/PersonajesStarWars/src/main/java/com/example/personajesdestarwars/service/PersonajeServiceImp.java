package com.example.personajesdestarwars.service;

import com.example.personajesdestarwars.dto.PersonajeDTO;
import com.example.personajesdestarwars.entity.Personaje;
import com.example.personajesdestarwars.repositories.IPersonajeRepository;
import com.example.personajesdestarwars.repositories.PersonajeRepositpryImp;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeServiceImp implements IPersonajeService {
    private IPersonajeRepository personajeRepository;

    public PersonajeServiceImp(PersonajeRepositpryImp personajeRepository) {
            this.personajeRepository = personajeRepository;
    }

    @Override
    public List<PersonajeDTO> findAllByNameContains(String query) {
        List<Personaje> personajes = personajeRepository.findAllByNameContains(query);
        List<PersonajeDTO> personajeDTOS = personajes.stream()
                .map(personaje -> new PersonajeDTO(personaje.getName(), personaje.getHeight(), personaje.getMass(), personaje.getGender(), personaje.getHomeworld(), personaje.getSpecies()))
                .collect(Collectors.toList());
        return personajeDTOS;
    }
}
