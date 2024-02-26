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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class FindControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;
    @Test
    void findLuke() throws Exception {
        List<CharacterDTO> expected = getLukeCharacterDtoList();
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String expectedJson = writer.writeValueAsString(expected);


        MvcResult result = mockMvc.perform(get("/{query}", "Luke"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(expectedJson, result.getResponse().getContentAsString());
    }

    private static List<CharacterDTO> getLukeCharacterDtoList() {
        CharacterDTO testCharacter = new CharacterDTO();
        testCharacter.setName("Luke Skywalker");
        testCharacter.setHair_color("blond");
        testCharacter.setSkin_color("fair");
        testCharacter.setEye_color("blue");
        testCharacter.setBirth_year("19BBY");
        testCharacter.setGender("male");
        testCharacter.setHomeworld("Tatooine");
        testCharacter.setSpecies("Human");
        testCharacter.setHeight(172);
        testCharacter.setMass(77);
        return List.of(testCharacter);
    }
}