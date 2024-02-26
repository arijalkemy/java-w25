package com.mercadolibre.starwars.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class CharacterRepositoryTests {

    @Autowired
    CharacterRepositoryImpl characterRepository;

    @Test
    void findAllByNameContainsTestOk(){
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
        // Act Y Assert
        Assertions.assertEquals(expected, characterRepository.findAllByNameContains(nameRequest));
    }
}
