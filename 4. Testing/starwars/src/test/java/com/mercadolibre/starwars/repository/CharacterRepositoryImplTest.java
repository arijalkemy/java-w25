package com.mercadolibre.starwars.repository;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CharacterRepositoryImplTest {

    CharacterRepositoryImpl characterRepository = new CharacterRepositoryImpl();

    @Test
    public void findAllBynameContainsTestOk() {
        // arrange
        String param = "Darth Maul";
        CharacterDTO characterDTO1 = new CharacterDTO();
        CharacterDTO characterDTO2 = new CharacterDTO();
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

        characterDTO2.setName("Darth Maul");
        List<CharacterDTO> devolucion = List.of(characterDTO1);

        // act - correr el metodo del repositorio
        var obtenido = characterRepository.findAllByNameContains(param);

        // assert
       Assertions.assertEquals(devolucion, obtenido);

    }

}
