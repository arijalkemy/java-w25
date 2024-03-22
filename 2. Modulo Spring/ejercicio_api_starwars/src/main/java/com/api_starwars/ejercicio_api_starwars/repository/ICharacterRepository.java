package com.api_starwars.ejercicio_api_starwars.repository;

import com.api_starwars.ejercicio_api_starwars.dto.CharacterDTO;

import java.util.List;

public interface ICharacterRepository {
    List<CharacterDTO> findAllByNameContains(String query);
}
