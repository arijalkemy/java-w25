package com.springlh.starwars_sala2.repository;

import com.springlh.starwars_sala2.dto.CharacterDTO;
import com.springlh.starwars_sala2.entity.StarWarsCharacter;

import java.util.List;

public interface CharacterRepository {
    List<StarWarsCharacter> findByName(String name);
}
