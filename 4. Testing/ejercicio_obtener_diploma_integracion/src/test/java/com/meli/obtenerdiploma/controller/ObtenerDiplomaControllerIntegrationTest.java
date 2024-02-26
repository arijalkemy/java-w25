package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
class ObtenerDiplomaControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;
    @BeforeEach
    @AfterEach
    public void loadStudents(){
        TestUtilsGenerator.loadUserFile();
    }
    @Test
    void analyzeScoresIntegrationOKTest() throws Exception {
        StudentDTO expectedStudent = new StudentDTO(
                1L,
                "Juan",
                "El alumno Juan ha obtenido un promedio de 7.00. Puedes mejorar.",
                7.0,
                List.of(
                        new SubjectDTO(
                                "Matematica",
                                7.0
                        ),
                        new SubjectDTO(
                                "Fisica", 7.0

                        ),
                        new SubjectDTO("Quimica", 7.0)
                )
        );
        ObjectWriter objectWriter = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        String expectedResponse = objectWriter.writeValueAsString(expectedStudent);
        MvcResult mvcResult =  mockMvc
                .perform(get("/analyzeScores/{studentId}", 1L))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        assertEquals(expectedResponse, mvcResult.getResponse().getContentAsString());
    }



}