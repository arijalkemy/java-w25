package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FindeServiceTest {

    @Mock
    CharacterRepository characterRepository;

    @InjectMocks
    FindService findService;

    @Test
    public void findTestOk() {
        // arrange
        String param = "Dart Maul";
        CharacterDTO characterDTO1 = new CharacterDTO();
        characterDTO1.setName("Darth Maul");
        characterDTO1.setHeight(175);
        characterDTO1.setMass(80);
        characterDTO1.setHair_color("none");
        characterDTO1.setSkin_color("red");
        characterDTO1.setEye_color("yellow");
        characterDTO1.setBirth_year("54BBY");
        characterDTO1.setGender("male");
        characterDTO1.setHomeworld("Dathomir");
        characterDTO1.setSpecies("Zabrak");

        List<CharacterDTO> devolucion = List.of(characterDTO1);

        // act
        Mockito.when(characterRepository.findAllByNameContains(param)).thenReturn(devolucion);

        var obtained = findService.find(param);

        // assert

        Assertions.assertEquals(devolucion,obtained);
    }
}
