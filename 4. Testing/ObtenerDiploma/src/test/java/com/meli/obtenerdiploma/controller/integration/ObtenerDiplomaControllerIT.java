package com.meli.obtenerdiploma.controller.integration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerIT {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Analizar promedios (IT) - Éxito")
    public void analyzeScoresCorrectIT() throws Exception {
        this.mockMvc.perform(get("/analyzeScores/{studentId}", 1L))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.studentName").value("Juan"))
                .andExpect(jsonPath("$.averageScore").value(7.333333333333333))
                .andExpect(jsonPath("$.subjects.length()").value(3))
        ;
    }

    @Test
    @DisplayName("Analizar promedios (IT) - Excepción")
    void analyzeScoresExceptionIT() throws Exception {
        this.mockMvc.perform(get("/analyzeScores/{studentId}", -1L))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("StudentNotFoundException"))
                .andExpect(jsonPath("$.description").value("El alumno con Id -1 no se encuetra registrado."));
    }
}
