package com.mercadolibre.starwars.controller;


import com.mercadolibre.starwars.dto.CharacterDTO;
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
public class FindControllerTests {

    @Mock
    FindService findService;

    @InjectMocks
    FindController findController;

    @Test
    void findTestOk() {
        // Arrange
        CharacterDTO request = new CharacterDTO();
        request.setName("Luke Skywalker");
        request.setHeight(172);
        request.setMass(77);
        request.setHair_color("blond");
        request.setSkin_color("fair");
        request.setEye_color("blue");
        request.setBirth_year("19BBY");
        request.setGender("male");
        request.setHomeworld("Tatooine");
        request.setSpecies("Human");
        String nameRequest = "Luke";
        List<CharacterDTO> expected = new ArrayList<>(List.of(request));
        // Act
        when(findService.find(nameRequest)).thenReturn(expected);
        // Assert
        Assertions.assertEquals(expected, findController.find(nameRequest));
    }

}
