package com.meli.obtenerdiploma.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerTestsIntegration {
    @Autowired
    MockMvc mockMvc;

    @Test
    void analyzeScoresTestOK() throws Exception{
        
        MvcResult mvcResult = mockMvc.perform(get("/analyzeScores/{studentId}",1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("El alumno Juan ha obtenido un promedio de 7,33. Puedes mejorar."))
                .andReturn();

    }

    @Test
    void analyzeScoresTestStudentNotFound() throws Exception{

        MvcResult mvcResult = mockMvc.perform(get("/analyzeScores/{studentId}",8))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.description").value("El alumno con Id 8 no se encuetra registrado."))
                .andReturn();

    }

}
