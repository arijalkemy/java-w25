package com.mercadolibre.starwars.service;


import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
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
import java.util.Set;

import static com.mercadolibre.starwars.utils.ObjectFactory.buildExpectedLukeCharacters;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class FindServiceTest {

    @Mock
    private CharacterRepositoryImpl characterRepository;

    @InjectMocks
    private FindService findService;

    @Test
    @DisplayName("Find character by name (Service) - Luke Success")
    void findLukeServiceTest() {
        //arrange
        String query = "Luke";
        List<CharacterDTO> characters = buildExpectedLukeCharacters();
        when(characterRepository.findAllByNameContains(query)).thenReturn(characters);

        //act
        List<CharacterDTO> readCharacters = findService.find(query);

        //assert
        verify(characterRepository, atLeast(1)).findAllByNameContains(query);
        assertEquals(characters, readCharacters);
    }

    @Test
    @DisplayName("Find character by name (Service) - Error")
    void findNoneServiceTest() {
        //arrange
        String query = "Java";
        List<CharacterDTO> characters = new ArrayList<>();
        when(characterRepository.findAllByNameContains(query)).thenReturn(characters);

        //act
        List<CharacterDTO> readCharacters = findService.find(query);

        //assert
        verify(characterRepository, atLeast(1)).findAllByNameContains(query);
        assertEquals(characters, readCharacters);
    }

}
