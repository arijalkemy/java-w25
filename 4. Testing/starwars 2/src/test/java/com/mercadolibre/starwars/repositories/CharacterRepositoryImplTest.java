package com.mercadolibre.starwars.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CharacterRepositoryImplTest {

    @InjectMocks
    CharacterRepositoryImpl characterRepositoryImpl;

    @Test
    void findAllByNameContainsTestOk() {
        // Arrange
        String query = "Luke";
        CharacterDTO lukeWalker = new CharacterDTO();
        lukeWalker.setName("Luke Skywalker");
        lukeWalker.setHair_color("blond");
        lukeWalker.setSkin_color("fair");
        lukeWalker.setBirth_year("19BBY");
        lukeWalker.setGender("male");
        lukeWalker.setHomeworld("Tatooine");
        lukeWalker.setHeight(172);
        lukeWalker.setMass(77);


        List<CharacterDTO> expectedList = List.of(lukeWalker);
        // Act
        System.out.println(expectedList.get(0).getClass());
        List<CharacterDTO> resultCharacterDTOList = characterRepositoryImpl.findAllByNameContains(query);
        System.out.println(resultCharacterDTOList.get(0).toString());
        // Assert
        Assertions.assertEquals(expectedList.size(), resultCharacterDTOList.size());

        for (int i = 0; i < expectedList.size(); i++) {
            CharacterDTO expected = expectedList.get(i);
            CharacterDTO actual = resultCharacterDTOList.get(i);

            // campos a comparar
            assertEquals(expected.getName(), actual.getName());
            assertEquals(expected.getHair_color(), actual.getHair_color());
            assertEquals(expected.getSkin_color(), actual.getSkin_color());
            assertEquals(expected.getBirth_year(), actual.getBirth_year());
            assertEquals(expected.getGender(), actual.getGender());
            assertEquals(expected.getHomeworld(), actual.getHomeworld());
            assertEquals(expected.getHeight(), actual.getHeight());
            assertEquals(expected.getMass(), actual.getMass());
        }
    }

}