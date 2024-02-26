package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.ArrayList;
import java.util.List;

import static com.mercadolibre.starwars.utils.ObjectFactory.buildExpectedLukeCharacters;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class FindControllerTest {

    @Mock
    FindService findService;

    @InjectMocks
    FindController findController;

    @Test
    @DisplayName("Find a character containing 'Luke' (Controller) - Success")
    public void findLukeTest(){
        //arrange
        String query = "Luke";
        List<CharacterDTO> characters = buildExpectedLukeCharacters();
        when(findService.find(query)).thenReturn(characters);
        //act
        List<CharacterDTO> readCharacters = findController.find(query);
        //assert
        assertEquals(characters, readCharacters);
    }

    @Test
    @DisplayName("Find a character containing 'Java' (Controller) - Error - Empty list")
    public void findErrorTest(){
        //arrange
        String query = "Java";
        List<CharacterDTO> characters = new ArrayList<>();
        when(findService.find(query)).thenReturn(characters);
        //act
        List<CharacterDTO> readCharacters = findController.find(query);
        //assert
        assertEquals(characters, readCharacters);
    }

}
