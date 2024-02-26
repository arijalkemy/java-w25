package com.mercadolibre.starwars.unit.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.when;

public class CharacterRepositoryTests {
    private CharacterRepositoryImpl characterRepository;

    CharacterRepositoryTests() {
        characterRepository = new CharacterRepositoryImpl();
    }

    @Test
    public void findAllByNameContainsTestLuke() {
        // ARRANGE
        CharacterDTO characterLuke = new CharacterDTO();
        characterLuke.setName("Luke Skywalker");
        characterLuke.setHeight(172);
        characterLuke.setMass(77);
        characterLuke.setHair_color("blond");
        characterLuke.setSkin_color("fair");
        characterLuke.setEye_color("blue");
        characterLuke.setBirth_year("19BBY");
        characterLuke.setGender("male");
        characterLuke.setHomeworld("Tatooine");
        characterLuke.setSpecies("Human");

        String query = "Luke";
        List<CharacterDTO> expected = List.of(characterLuke);
        // ACT
        List<CharacterDTO> result = characterRepository.findAllByNameContains(query);
        // ASSERT
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void findAllByNameContainsTestEmpty() {
        // ARRANGE
        List<CharacterDTO> expected = List.of();
        // ACT
        List<CharacterDTO> result = characterRepository.findAllByNameContains("David");
        // ASSERT
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void findTestDarth() {
        // ARRANGE
        CharacterDTO characterVader = new CharacterDTO();
        characterVader.setName("Darth Vader");
        characterVader.setHeight(202);
        characterVader.setMass(136);
        characterVader.setHair_color("none");
        characterVader.setSkin_color("white");
        characterVader.setEye_color("yellow");
        characterVader.setBirth_year("41.9BBY");
        characterVader.setGender("male");
        characterVader.setHomeworld("Tatooine");
        characterVader.setSpecies("Human");

        CharacterDTO characterMaul = new CharacterDTO();
        characterMaul.setName("Darth Maul");
        characterMaul.setHeight(175);
        characterMaul.setMass(80);
        characterMaul.setHair_color("none");
        characterMaul.setSkin_color("red");
        characterMaul.setEye_color("yellow");
        characterMaul.setBirth_year("54BBY");
        characterMaul.setGender("male");
        characterMaul.setHomeworld("Dathomir");
        characterMaul.setSpecies("Zabrak");

        String query = "Darth";
        List<CharacterDTO> expected = List.of(characterVader, characterMaul);
        // ACT
        List<CharacterDTO> result = characterRepository.findAllByNameContains(query);
        // ASSERT
        Assertions.assertEquals(expected, result);
    }
}
