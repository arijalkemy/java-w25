package com.mercadolibre.calculadorametroscuadrados.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculateRestControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
  void calculateHouseWithOneRoom() throws Exception {
    String request = "{\"name\": \"Oficina\", \"address\": \"Monroe 800\", \"rooms\": [{\n" +
            "      \"name\": \"dormitiorio\",\n" +
            "      \"width\": 3,\n" +
            "      \"length\": 3,\n" +
            "      \"squareFeet\": 9\n" +
            "    }]}";
    this.mockMvc.perform(
        post("/calculate")
        .contentType(MediaType.APPLICATION_JSON)
        .content(request))
        .andDo(print()).andExpect(status().isOk())
        .andExpect(content().string(containsString("9")));
  }
}
