package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerIntegration {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void analyzeScoresOkTest() throws Exception {
        Long studentId = 1L;

        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/analyzeScores/{studentId}", studentId))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.averageScore")
                        .value(7.333333333333333))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message")
                        .value("El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar."))
                .andReturn();
    }

    @Test
    public void analyzeScoresExceptionTest() throws Exception {
        Long studentId = 999L;

        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/analyzeScores/{studentId}", studentId))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof StudentNotFoundException))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name")
                        .value("StudentNotFoundException"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description")
                        .value("El alumno con Id 999 no se encuetra registrado."));
    }
}
