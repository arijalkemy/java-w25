package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class FindControllerTest {
    @Mock
    FindService service;

    @InjectMocks
    FindController controller;

    @Test
    void find(){
        // Arrange
        List<CharacterDTO> characters=new ArrayList<>();

        CharacterDTO character1=new CharacterDTO();
        character1.setName("Luke Skywalker");
        character1.setHair_color("blond");
        character1.setSkin_color("fair");
        character1.setEye_color("blue");
        character1.setBirth_year("19BBY");
        character1.setGender("male");
        character1.setHomeworld("Tatooine");
        character1.setSpecies("Human");
        character1.setHeight(172);
        character1.setMass(77);

        characters.add(character1);

        Mockito.when(service.find("Luke")).thenReturn(characters);

        // Act
        List<CharacterDTO> charactersResult=controller.find("Luke");

        // Assert
        Mockito.verify(service, Mockito.atLeastOnce()).find("Luke");
        Assertions.assertEquals(characters, charactersResult);
    }
}