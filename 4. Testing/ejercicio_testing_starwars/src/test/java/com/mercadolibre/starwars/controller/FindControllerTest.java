package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import com.mercadolibre.starwars.util.TestGeneratorUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FindControllerTest {
    @Mock
    FindService findService;
    @InjectMocks
    FindController findController;
    @Test
    void find() {
        //arrange
        List<CharacterDTO> expectedCharacters = List.of(TestGeneratorUtil.getLuke());
        String wordToLookFor = "Luke";
        when(findService.find("Luke")).thenReturn(expectedCharacters);
        //act
        List<CharacterDTO> actualCharacters = findController.find(wordToLookFor);
        //assert
        verify(findService, atLeast(1)).find(wordToLookFor);
        assertTrue(CollectionUtils.isEqualCollection(expectedCharacters, actualCharacters));

    }
}