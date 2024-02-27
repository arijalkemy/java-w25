package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindControllerTest {

    @Mock
    FindService findService;
    @InjectMocks
    FindController findController;

    @Test
    void findCharacterOK(){
        CharacterDTO characterDTOExpected = new CharacterDTO(
                "Luke Skywalker",
                "blond",
                "fair",
                "blue",
                "19BBY",
                "male",
                "Tatooine",
                "Human",
                172,
                77
        );
        when(findService.find(anyString())).thenReturn(Arrays.asList(mockCharacterDTO()));

        List<CharacterDTO> response = findController.find("Luke");

        assertThat(response.get(0)).usingRecursiveComparison().isEqualTo(characterDTOExpected);
        Assertions.assertEquals(characterDTOExpected.getName(),response.get(0).getName());

    }

    private CharacterDTO mockCharacterDTO(){
        return new CharacterDTO(
                "Luke Skywalker",
                "blond",
                "fair",
                "blue",
                "19BBY",
                "male",
                "Tatooine",
                "Human",
                172,
                77
        );
    }


}
