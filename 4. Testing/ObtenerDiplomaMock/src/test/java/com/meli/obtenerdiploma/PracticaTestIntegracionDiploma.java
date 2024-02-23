package com.meli.obtenerdiploma;

import org.junit.jupiter.api.DisplayName;
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
public class PracticaTestIntegracionDiploma {
/*
Se requiere crear los tests de integración necesarios para cubrir el comportamiento
de la capa de los controladores ObtenerDiplomaController y StudentController.
 Tener en cuenta múltiples escenarios, incluidos las validaciones, mensajes de error y Excepciones.
 */
    @Autowired
    MockMvc mockMvc;

    @DisplayName("analyzeScore - HAPPY PATH")
    @Test
    void analyzeScoreTestHappyPath() throws Exception{
        MvcResult mvcResult = mockMvc.perform(get("/analyzeScores/{studentId}",3L))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("El alumno Edgar ha obtenido un promedio de 8. Puedes mejorar."))
                .andReturn();
    }

    @Test
    @DisplayName("analyzeScore NotFound Path")
    void analyzeScoreTestNotFoundPath() throws Exception{
        MvcResult mvcResult = mockMvc.perform(get("/analyzeScores/{studentId}",-3L))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("StudentNotFoundException"))
                .andReturn();
    }

    @Test
    @DisplayName("Analyze Score - MissMatch type" )
    void analyzeScoreTestPath() throws Exception{
        MvcResult mvcResult = mockMvc.perform(get("/analyzeScores/{studentId}",3.0))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andReturn();
    }

}
