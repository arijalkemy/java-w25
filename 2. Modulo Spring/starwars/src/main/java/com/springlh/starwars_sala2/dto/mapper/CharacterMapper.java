package com.springlh.starwars_sala2.dto.mapper;

import com.springlh.starwars_sala2.entity.StarWarsCharacter;
import com.springlh.starwars_sala2.dto.CharacterDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CharacterMapper {

    public static CharacterDTO getInstance(StarWarsCharacter starWarsCharacter) {
        CharacterDTO dto = CharacterDTO.builder()
                .name(starWarsCharacter.getName())
                .gender(starWarsCharacter.getGender())
                .height(starWarsCharacter.getHeight())
                .mass(starWarsCharacter.getMass())
                .hairColor(starWarsCharacter.getHair_color())
                .skinColor(starWarsCharacter.getSkin_color())
                .birthYear(starWarsCharacter.getBirth_year())
                .eyeColor(starWarsCharacter.getEye_color())
                .homeworld(starWarsCharacter.getHomeworld())
                .species(starWarsCharacter.getSpecies())
                .build();

        return dto;
    }

    public static List<CharacterDTO> getInstances(List<StarWarsCharacter> starWarsCharacters) {
        return starWarsCharacters.stream().map(CharacterMapper::getInstance).collect(Collectors.toList());
    }
}
