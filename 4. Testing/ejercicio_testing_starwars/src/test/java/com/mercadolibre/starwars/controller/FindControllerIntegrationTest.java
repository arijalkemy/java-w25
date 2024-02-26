package com.mercadolibre.starwars.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.util.TestGeneratorUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@AutoConfigureMockMvc
@SpringBootTest
public class FindControllerIntegrationTest {
    @Autowired
    FindController findController;
    @Autowired
    MockMvc mockMvc;
    @Test
    void findAll() throws Exception {
        //assert
        String wordToLookFor = "Luke";
        List<CharacterDTO> expectedCharacters = List.of(TestGeneratorUtil.getLuke());
        ObjectWriter objectWriter = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        String expectedCharactersString = objectWriter.writeValueAsString(expectedCharacters);
        // act
        MvcResult result = mockMvc.perform(get("/{query}", wordToLookFor))
                .andDo(print()).andReturn();
        //assert
        assertEquals(expectedCharactersString, result.getResponse().getContentAsString());
    }
}
