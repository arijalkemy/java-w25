package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FindControllerTest {

    @Mock
    FindService findService;

    @InjectMocks
    FindController controller;

    @Test
    public void findTestOk() {
        // arrange
        String param = "Darth Maul";
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

        when(findService.find(param)).thenReturn(devolucion);

        // act
        List<CharacterDTO> obtained = controller.find(param);

        // assert
        verify(findService, atLeastOnce()).find(param);
        Assertions.assertEquals(devolucion, obtained);
    }
}
