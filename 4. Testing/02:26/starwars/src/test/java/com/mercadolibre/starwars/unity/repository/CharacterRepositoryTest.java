package com.mercadolibre.starwars.unity.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;

@SpringBootTest
public class CharacterRepositoryTest {
    static CharacterRepositoryImpl characterRepositoryImpl = new CharacterRepositoryImpl();

    @Test
    public void findAllByNameContainsOkest() {
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
        // Act:
        List<CharacterDTO> result = characterRepositoryImpl.findAllByNameContains(param.getName());
        // Assert:
        assertEquals(1, result.size());
        assertEquals(param.getName(), result.get(0).getName());
    }

    @Test
    public void findAllByNameContainsNotOkest() {
        // Arrange:
        CharacterDTO param = new CharacterDTO();
        param.setName("PersonajeFalso123");
        param.setHair_color("blond");
        param.setSkin_color("fair");
        param.setEye_color("blue");
        param.setBirth_year("19BBY");
        param.setGender("male");
        param.setHomeworld("Tatooine");
        param.setSpecies("Human");
        param.setHeight(172);
        param.setMass(77);
        // Act:
        List<CharacterDTO> result = characterRepositoryImpl.findAllByNameContains(param.getName());
        // Assert:
        assertEquals(0, result.size());
    }

}
