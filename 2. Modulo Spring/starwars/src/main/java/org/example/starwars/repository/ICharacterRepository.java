package org.example.starwars.repository;

import org.example.starwars.character.CharacterModel;

import java.util.List;

public interface ICharacterRepository {
    List<CharacterModel> findAllByNameLike(String like);
}
