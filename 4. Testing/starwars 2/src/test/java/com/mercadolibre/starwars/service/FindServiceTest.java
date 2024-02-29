package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@ExtendWith(MockitoExtension.class)
// @SpringBootTest
class FindServiceTest {

    @Mock
    CharacterRepository characterRepository;

    @InjectMocks
    FindService findService;

    @Test
    void findOkTest() {
        // Arrange
        String query = "Luke";
        CharacterDTO testCharacter = new CharacterDTO();
        testCharacter.setName("Luke");
        testCharacter.setHair_color("black");
        testCharacter.setSkin_color("light");
        testCharacter.setBirth_year("1990");
        testCharacter.setGender("male");
        testCharacter.setHomeworld("earth");
        testCharacter.setHeight(50);
        testCharacter.setMass(60);

        CharacterDTO testCharacter2 = new CharacterDTO();
        testCharacter2.setName("Luke Walker");
        testCharacter2.setHair_color("blue");
        testCharacter2.setSkin_color("light");
        testCharacter2.setBirth_year("1995");
        testCharacter2.setGender("female");
        testCharacter2.setHomeworld("earth");
        testCharacter2.setHeight(80);
        testCharacter2.setMass(60);

        List<CharacterDTO> expectedList = List.of(testCharacter, testCharacter2);
        // Act
        Mockito.when(characterRepository.findAllByNameContains(query)).thenReturn(expectedList);
        List<CharacterDTO> resultCharacterDTOList = findService.find(query);

        // Assert
        Assertions.assertEquals(expectedList, resultCharacterDTOList);
    }
}