package com.meli.starwars.service;

import com.meli.starwars.dto.CharacterDTO;
import com.meli.starwars.repositories.CharacterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindService {
    private final CharacterRepository characterRepository;

    public FindService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public List<CharacterDTO> find(String query) {
        return characterRepository.findAllByNameContains(query);
    }
}
