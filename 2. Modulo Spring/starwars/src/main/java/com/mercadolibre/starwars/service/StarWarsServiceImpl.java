package com.mercadolibre.starwars.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.model.Character;
import com.mercadolibre.starwars.repository.StarWarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StarWarsServiceImpl implements StarWarsService {

    @Autowired
    private final StarWarsRepository starWarsRepository;

    public StarWarsServiceImpl(StarWarsRepository starWarsRepository) {
        this.starWarsRepository = starWarsRepository;
    }

    @Override
    public List<CharacterDTO> findCharacters(String name) {

        return starWarsRepository.loadCharacters().stream()
                .filter(character -> character.getName().toLowerCase().contains(name.toLowerCase()))
                .map(character -> new CharacterDTO(character.getName(), character.getHeight(), character.getMass(), character.getGender(), character.getHomeWorld(), character.getSpecies()))
                .collect(Collectors.toList());
    }


}
