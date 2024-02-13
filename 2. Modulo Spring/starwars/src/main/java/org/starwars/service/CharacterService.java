package org.starwars.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.starwars.dto.response.PersonajeDTO;
import org.starwars.repository.CharacterRepository;

import java.util.List;

@Service
public class CharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    public List<PersonajeDTO> findCharacter(String name){

        characterRepository = new CharacterRepository();

        return characterRepository.test().stream().map( p -> new PersonajeDTO(p.name, p.height, p.mass, p.gender, p.homeworld, p.species)).toList();
    }


}
