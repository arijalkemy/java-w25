package com.Starwars.StarwarsPersonajes.service;

import com.Starwars.StarwarsPersonajes.dto.PersonajeDTO;
import com.Starwars.StarwarsPersonajes.repository.PersonajeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StarwarsService {
    private PersonajeRepository personajeRepository;

    public StarwarsService(){
        this.personajeRepository = new PersonajeRepository();
    }

    public List<PersonajeDTO> findCharacters (String name){
        return personajeRepository.getPersonajes().stream()
                .filter(x -> x.getName().toLowerCase().contains(name.toLowerCase()))
                .map(person -> new PersonajeDTO(person.getName(),person.getHeight(),person.getMass(),person.getGender(),person.getHomeworld(),person.getSpecies()))
                .toList();
    }
}
