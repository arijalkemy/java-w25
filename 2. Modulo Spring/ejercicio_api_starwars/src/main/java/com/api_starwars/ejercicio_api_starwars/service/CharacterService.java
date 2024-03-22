package com.api_starwars.ejercicio_api_starwars.service;

import com.api_starwars.ejercicio_api_starwars.dto.CharacterDTO;
import com.api_starwars.ejercicio_api_starwars.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {
    @Autowired
    private CharacterRepository characterRepository;

    public List<CharacterDTO> find(String query){
        return  characterRepository.findAllByNameContains(query);
    }
}
