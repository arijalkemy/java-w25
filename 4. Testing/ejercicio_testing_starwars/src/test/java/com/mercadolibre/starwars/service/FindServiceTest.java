package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import com.mercadolibre.starwars.util.TestGeneratorUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FindServiceTest {
    @Mock
    CharacterRepositoryImpl characterRepository;
    @InjectMocks
    FindService findService;

    @Test
    void find() {
        //arrange
        List<CharacterDTO> expectedCharacter = List.of(TestGeneratorUtil.getLuke());
        String wordToLookFor = "Luke";
        when(characterRepository.findAllByNameContains(wordToLookFor)).thenReturn(expectedCharacter);
        //act
        List<CharacterDTO> actualCharacters = findService.find(wordToLookFor);

        //assert
        verify(characterRepository, atLeast(1)).findAllByNameContains(wordToLookFor);
        assertTrue(CollectionUtils.isEqualCollection(expectedCharacter, actualCharacters));
    }
}