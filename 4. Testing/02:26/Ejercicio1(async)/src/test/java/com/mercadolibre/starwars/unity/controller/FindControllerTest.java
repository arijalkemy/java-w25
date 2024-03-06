package com.mercadolibre.starwars.unity.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.mercadolibre.starwars.controller.FindController;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class FindControllerTest {
    @Mock
    FindService findService;

    @InjectMocks
    FindController findController;

    @Test
    public void findOkTest() {
        // Arrange:
        CharacterDTO param = new CharacterDTO();
        param.setName("Luke Skywalker");
        param.setHair_color("blond");
        param.setSkin_color("fair");
        param.setEye_color("blue");
        param.setBirth_year("19BBY");
        param.setGender("male");
        param.setHomeworld("Tatooine");
        param.setSpecies("Human");
        param.setHeight(172);
        param.setMass(77);
        when(findService.find(param.getName())).thenReturn(List.of(param));
        // Act:
        List<CharacterDTO> result = findService.find(param.getName());
        // Assert:
        assertEquals(1, result.size());
        assertEquals(param.getName(), result.get(0).getName());
        verify(findService, atLeastOnce()).find(param.getName());
    }

    @Test
    public void findNotOkTest() {
        // Arrange:
        CharacterDTO param = new CharacterDTO();
        param.setName("Luke Skywalker");
        param.setHair_color("blond");
        param.setSkin_color("fair");
        param.setEye_color("blue");
        param.setBirth_year("19BBY");
        param.setGender("male");
        param.setHomeworld("Tatooine");
        param.setSpecies("Human");
        param.setHeight(172);
        param.setMass(77);
        when(findService.find(param.getName())).thenReturn(List.of());
        // Act:
        List<CharacterDTO> result = findService.find(param.getName());
        // Assert:
        assertEquals(0, result.size());
        verify(findService, atLeastOnce()).find(param.getName());
    }
}
