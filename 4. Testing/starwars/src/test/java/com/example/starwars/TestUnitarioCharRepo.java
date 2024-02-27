package com.example.starwars;

import com.example.starwars.dto.CharacterDTO;
import com.example.starwars.repositories.CharacterRepositoryImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class TestUnitarioCharRepo {
    @Autowired
    CharacterRepositoryImpl characterRepository;
    @Test
    public void repoTestOk() throws JsonProcessingException {
        //ASSERT
        List<CharacterDTO> expected = new ArrayList<>();
        expected.add(new CharacterDTO("Plo Koon", "none",
                "orange", "black", "22BBY",
                "male", "Dorin", "Kel Dor",
                188, 80));

        ObjectMapper objectMapper = new ObjectMapper();
        String expectedJson = objectMapper.writeValueAsString(expected);
        //ACT
        List<CharacterDTO> actual = characterRepository.findAllByNameContains("Koon");
        String actualJson = objectMapper.writeValueAsString(actual);

        System.out.println("Expected JSON: " + expectedJson);
        System.out.println("Actual JSON: " + actualJson);
        //ARRANGE
        assertEquals(expectedJson, actualJson);
        }

    @Test
    public void repoTestNotEqualsPath() throws JsonProcessingException {
        //ASSERT
        List<CharacterDTO> expected = new ArrayList<>();
        expected.add(new CharacterDTO("Plo Koon", "none",
                "orange", "black", "22BBY",
                "male", "Dorin", "Kel Dor",
                188, 80));

        ObjectMapper objectMapper = new ObjectMapper();
        String expectedJson = objectMapper.writeValueAsString(expected);
        //ACT
        List<CharacterDTO> actual = characterRepository.findAllByNameContains("Organa");
        String actualJson = objectMapper.writeValueAsString(actual);

        System.out.println("Expected JSON: " + expectedJson);
        System.out.println("Actual JSON: " + actualJson);
        //ARRANGE
        assertNotEquals(expectedJson, actualJson);
    }
}
