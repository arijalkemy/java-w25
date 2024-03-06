package com.mercadolibre.starwars.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;

@SpringBootTest
@AutoConfigureMockMvc
public class FindControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void findOkTest() throws Exception {
        String request = "luke";
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/{request}", request))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name")
                        .value("Luke Skywalker"))
                .andReturn();
    }

    @Test
    public void findNotOkTest() throws Exception {
        String request = "PersonajeFalso";
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/{request}", request))
                .andExpect(status().isOk())
                .andDo(result -> {
                    String jsonResponse = result.getResponse().getContentAsString();
                    List<Object> jsonList = new ObjectMapper().readValue(jsonResponse,
                            new TypeReference<List<Object>>() {
                            });
                    assertEquals(0, jsonList.size());
                });
    }

}
