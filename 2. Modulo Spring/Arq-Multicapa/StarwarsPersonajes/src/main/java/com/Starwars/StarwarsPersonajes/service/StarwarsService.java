package com.Starwars.StarwarsPersonajes.service;

import com.Starwars.StarwarsPersonajes.dto.PersonajeDTO;
import com.Starwars.StarwarsPersonajes.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StarwarsService {

    @Autowired
    PersonajeRepository personajeRepository;

    public List<PersonajeDTO> findCharacters (String name){
        return personajeRepository.getPersonajes().stream()
                .filter(x -> x.getName().toLowerCase().contains(name.toLowerCase()))
                .map(person -> new PersonajeDTO(person.getName(),person.getHeight(),person.getMass(),person.getGender(),person.getHomeworld(),person.getSpecies()))
                .toList();
    }
}
