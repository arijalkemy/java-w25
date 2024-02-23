package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerIntegracion {

    @Autowired
    MockMvc mockMvc;


    @BeforeEach
    public void initJson(){

    }

    @Test
    void analyzeScoresOkTest() throws Exception{
        StudentDTO stu = TestUtilsGenerator.getStudentFromDatabase();
        stu.setAverageScore(7.333333333333333);
        stu.setMessage("El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.");

        ObjectWriter writer = new ObjectMapper()
                    .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                    .writer();

        String expectedJson = writer.writeValueAsString(stu);

        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders
                .get("/analyzeScores/{studentId}", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(expectedJson, result.getResponse().getContentAsString());
    }

    @Test
    void analyzeScoresNotFoundTest() throws Exception{
        Long notExistingId = 50L;

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/analyzeScores/{studentId}", notExistingId))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("El alumno con Id 50 no se encuetra registrado."));
    }

}
