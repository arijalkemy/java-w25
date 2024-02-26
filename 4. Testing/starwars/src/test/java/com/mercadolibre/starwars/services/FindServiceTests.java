package com.mercadolibre.starwars.services;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindServiceTests {
    @Mock
    CharacterRepositoryImpl characterRepository;
    @InjectMocks
    FindService findService;

    @Test
    void findTestOk() {
        // Arrange
        CharacterDTO expectedCharacter = new CharacterDTO();
        expectedCharacter.setName("Luke Skywalker");
        expectedCharacter.setHeight(172);
        expectedCharacter.setMass(77);
        expectedCharacter.setHair_color("blond");
        expectedCharacter.setSkin_color("fair");
        expectedCharacter.setEye_color("blue");
        expectedCharacter.setBirth_year("19BBY");
        expectedCharacter.setGender("male");
        expectedCharacter.setHomeworld("Tatooine");
        expectedCharacter.setSpecies("Human");
        String nameRequest = "Luke";
        List<CharacterDTO> expected = new ArrayList<>(List.of(expectedCharacter));
        // Act
        when(characterRepository.findAllByNameContains(nameRequest)).thenReturn(expected);
        // Assert
        Assertions.assertEquals(expected, findService.find(nameRequest));
    }
}
