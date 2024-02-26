package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerTestIntegration {
    @Autowired
    MockMvc mockMvc;

    @BeforeAll
    public static void setUp(){
        TestUtilsGenerator.emptyUsersFile();
        TestUtilsGenerator.appendNewStudent(new StudentDTO(1L, "Juan", null, null,
                List.of(new SubjectDTO("Matematica", 9D), new SubjectDTO("Fisica", 7D), new SubjectDTO("Quimica", 6D))));
        TestUtilsGenerator.appendNewStudent(new StudentDTO(2L, "Pedro", null, null,
                List.of(new SubjectDTO("Matematica", 10D), new SubjectDTO("Fisica", 8D), new SubjectDTO("Quimica", 4D))));
    }

    @Test
    void analyzeScoresTestOK() throws Exception{
        
        MvcResult mvcResult = mockMvc.perform(get("/analyzeScores/{studentId}",1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar."))
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
