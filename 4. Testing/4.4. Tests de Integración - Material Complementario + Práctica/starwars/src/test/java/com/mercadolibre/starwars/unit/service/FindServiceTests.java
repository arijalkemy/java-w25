package com.mercadolibre.starwars.unit.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindServiceTests {
    @Mock
    private CharacterRepositoryImpl characterRepository;
    @InjectMocks
    private FindService findService;

    @Test
    public void findTestLuke() {
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
        when(characterRepository.findAllByNameContains(query)).thenReturn(List.of(characterLuke));
        // ACT
        List<CharacterDTO> result = findService.find(query);
        // ASSERT
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void findTestEmpty() {
        // ARRANGE
        String query = "David";
        List<CharacterDTO> expected = List.of();
        when(characterRepository.findAllByNameContains(query)).thenReturn(List.of());
        // ACT
        List<CharacterDTO> result = findService.find(query);
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
        when(characterRepository.findAllByNameContains(query)).thenReturn(List.of(characterVader, characterMaul));
        // ACT
        List<CharacterDTO> result = findService.find(query);
        // ASSERT
        Assertions.assertEquals(expected, result);
    }
}
