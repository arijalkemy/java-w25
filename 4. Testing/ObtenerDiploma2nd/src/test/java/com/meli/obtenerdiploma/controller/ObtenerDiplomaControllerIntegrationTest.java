package com.meli.obtenerdiploma.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void analyzeScoresTestOk() throws Exception {
         this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}",1))
                        .andDo(print())
                        .andExpect(status().isOk())
                 .andExpect(content().contentType("application/json"))
                 .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                 .andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value("Juan"))
                 .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("El alumno Juan ha obtenido un promedio de 7,33. Puedes mejorar."));
    }

    @Test
    public void analyzeScoresTestFail() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}",999))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("StudentNotFoundException"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("El alumno con Id 999 no se encuetra registrado."));
    }

    @Test
    public void analyzeScoresTestEmpty() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}",null))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("StudentNotFoundException"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("El alumno con Id 999 no se encuetra registrado."));
    }


}
