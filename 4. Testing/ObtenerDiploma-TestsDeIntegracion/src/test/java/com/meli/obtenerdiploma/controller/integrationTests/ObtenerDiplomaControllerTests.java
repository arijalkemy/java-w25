package com.meli.obtenerdiploma.controller.integrationTests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    void analizeScoresTestOk() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 250L))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.studentName").value("Pepe"))
                .andReturn();
    }
    @Test
    void analizeScoresTestSadPath() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 1000L))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("StudentNotFoundException"))
                .andReturn();
    }

}
