package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.ErrorDTO;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class IntegrationObtenerDiplomaTest {

    @Autowired
    MockMvc mockMvc;

    static ObjectWriter writer;

    @BeforeAll
    static void setup(){
        writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE,false).writer();
    }

    @Test
    void okTest() throws Exception {

        StudentDTO studentDTO = TestUtilsGenerator.getStudentWithId2(1L);
        studentDTO.setMessage("El alumno Juan ha obtenido un promedio de 6.00. Puedes mejorar.");
        studentDTO.setAverageScore(6.0);
        String expected = writer.writeValueAsString(studentDTO);
        mockMvc.perform(get("/analyzeScores/{studentId}",1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(expected))
                .andReturn();


    }

    @Test
    void errorTest() throws Exception {

        ErrorDTO errorDTO = new ErrorDTO("StudentNotFoundException","El alumno con Id 3 no se encuetra registrado.");

        String expected = writer.writeValueAsString(errorDTO);
        mockMvc.perform(get("/analyzeScores/{studentId}","3"))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(expected));

    }

}

