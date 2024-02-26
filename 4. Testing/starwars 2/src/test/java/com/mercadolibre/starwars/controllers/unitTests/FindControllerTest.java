package com.mercadolibre.starwars.controllers.unitTests;

import com.mercadolibre.starwars.controller.FindController;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class FindControllerTest {
    @Mock
    FindService service;

    @InjectMocks
    FindController controller;

    @Test
    public void searchSuccessful(){
        List<CharacterDTO> characterDTOS = List.of(new CharacterDTO("Darth Vader", "none", "white", "yellow",
                "41.9BBY", "male", "Tatooine", "Human",
                202, 136));

        when(controller.find("Darth")).thenReturn(characterDTOS);

        List<CharacterDTO> currentCharacters = controller.find("Darth");

        assertEquals(characterDTOS, currentCharacters);
    }

    @Test
    public void searchUnsuccessful(){
        List<CharacterDTO> characterDTOS = List.of(new CharacterDTO("Darth Vader", "none", "white", "yellow",
                "41.9BBY", "male", "Tatooine", "Human",
                202, 136));

        when(controller.find("xx")).thenReturn(characterDTOS);

        List<CharacterDTO> currentCharacters = controller.find("Darth");

        assertNotEquals(characterDTOS, currentCharacters);
    }
}
