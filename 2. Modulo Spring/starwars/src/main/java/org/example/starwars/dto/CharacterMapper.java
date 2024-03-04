package org.example.starwars.dto;

import org.example.starwars.character.CharacterModel;

public class CharacterMapper {
    public static CharacterDTO getCharacterDTO(CharacterModel characterModel){
        return new CharacterDTO(characterModel.getName(), characterModel.getHeight(), characterModel.getMass(), characterModel.getGender()
                , characterModel.getHomeworld(), characterModel.getSpecies());
    }
}
