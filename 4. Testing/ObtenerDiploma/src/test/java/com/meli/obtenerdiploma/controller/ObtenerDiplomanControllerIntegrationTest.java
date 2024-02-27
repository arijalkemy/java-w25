package com.meli.obtenerdiploma.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ObtenerDiplomanControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void analyzeScoreOK() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}",1L))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("El alumno Juan ha obtenido un promedio de 7,33. Puedes mejorar."));
    }
    @Test
    void analyzeScoreStudentNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}",5L))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("El alumno con Id 5 no se encuetra registrado."));
    }
}
