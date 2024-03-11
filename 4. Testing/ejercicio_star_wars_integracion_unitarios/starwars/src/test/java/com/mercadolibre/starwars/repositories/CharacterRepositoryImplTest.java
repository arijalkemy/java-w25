package com.mercadolibre.starwars.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CharacterRepositoryImplTest {
    CharacterRepository characterRepository;

    @BeforeEach
    void setUp(){
        this.characterRepository=new CharacterRepositoryImpl();
    }

    @Test
    void findAllByNameContains(){
        // Arrange
        List<CharacterDTO> characters=new ArrayList<>();

        CharacterDTO character1=new CharacterDTO();
        character1.setName("Luke Skywalker");
        character1.setHair_color("blond");
        character1.setSkin_color("fair");
        character1.setEye_color("blue");
        character1.setBirth_year("19BBY");
        character1.setGender("male");
        character1.setHomeworld("Tatooine");
        character1.setSpecies("Human");
        character1.setHeight(172);
        character1.setMass(77);

        characters.add(character1);

        // Act
        List<CharacterDTO> charactersResult=characterRepository.findAllByNameContains("Luke");

        // Assert
        assertEquals(1, charactersResult.size());
        assertEquals(characters.get(0).getName(), charactersResult.get(0).getName());
    }
}