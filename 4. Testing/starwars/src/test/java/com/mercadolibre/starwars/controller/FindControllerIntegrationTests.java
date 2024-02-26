package com.mercadolibre.starwars.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FindControllerIntegrationTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    void findTestOk() throws Exception {
        // Arrange
        String nameRequest = "Luke";
        CharacterDTO expectedCharacter = new CharacterDTO();
        expectedCharacter.setName("Luke Skywalker");
        expectedCharacter.setHeight(172);
        expectedCharacter.setMass(77);
        expectedCharacter.setHair_color("blond");
        expectedCharacter.setSkin_color("fair");
        expectedCharacter.setEye_color("blue");
        expectedCharacter.setBirth_year("19BBY");
        expectedCharacter.setGender("male");
        expectedCharacter.setHomeworld("Tatooine");
        expectedCharacter.setSpecies("Human");
        List<CharacterDTO> expected = new ArrayList<>(List.of(expectedCharacter));

        ObjectWriter writter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer(); // sin el prettyPinter para que no rompa

        String expectedJson = writter.writeValueAsString(expected);
        // Act
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/{name}", nameRequest))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        // Assert
        Assertions.assertEquals(expectedJson, result.getResponse().getContentAsString());
    }
}
