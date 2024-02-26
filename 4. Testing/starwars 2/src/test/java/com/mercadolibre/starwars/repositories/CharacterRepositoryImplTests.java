package com.mercadolibre.starwars.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CharacterRepositoryImplTests {

    @Mock
    CharacterRepository repository;

    @Test
    public void findAllByNameContainsTest() {
        List<CharacterDTO> characterDTOS = List.of(
                new CharacterDTO(
                        "Darth Vader",
                        "none",
                        "white",
                        "yellow",
                        "41.9BBY",
                        "male",
                        "Tatooine",
                        "Human",
                        202,
                        136),
                new CharacterDTO(
                        "Darth Maul",
                        "none",
                        "red",
                        "yellow",
                        "54BBY",
                        "male",
                        "Dathomir",
                        "Zabrak",
                        175,
                        80
                )
        );

        when(repository.findAllByNameContains("Darth")).thenReturn(characterDTOS);

        List<CharacterDTO> characterDTOSExpected = repository.findAllByNameContains("Darth");

        assertEquals(characterDTOSExpected.size(),2);
    }

    @Test
    public void findAllByNameContainsTest2() {
        List<CharacterDTO> characterDTOS = List.of(
                new CharacterDTO(
                        "Darth Vader",
                        "none",
                        "white",
                        "yellow",
                        "41.9BBY",
                        "male",
                        "Tatooine",
                        "Human",
                        202,
                        136),
                new CharacterDTO(
                        "Darth Maul",
                        "none",
                        "red",
                        "yellow",
                        "54BBY",
                        "male",
                        "Dathomir",
                        "Zabrak",
                        175,
                        80
                )
        );

        CharacterRepositoryImpl repository1 = new CharacterRepositoryImpl();

        List<CharacterDTO> characterDTOSExpected = repository1.findAllByNameContains("Darth");

        assertEquals(2, characterDTOSExpected.size());
    }



}
