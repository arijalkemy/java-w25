package com.meli.obtenerdiploma.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.apache.http.client.methods.RequestBuilder.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerIntegrationTests {

    @Autowired
    MockMvc mockMvc;

    // camino triste
    @Test
    public void analyzeScoresTestNotFound() throws Exception {
        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentID}", "-1"))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andReturn();
    }

    // Camino feliz con promedio menor a 8
    @Test
    @DisplayName(value = "Promedio menor a ocho (8)")
    public void analyzeScoresTestOKNoBest() throws Exception {

        // Arrange
        SubjectDTO subject1 = new SubjectDTO("Fisica", 8D);
        SubjectDTO subject3 = new SubjectDTO("Quimica", 4D);
        SubjectDTO subject2 = new SubjectDTO("Matematica", 10D);
        StudentDTO expected = new StudentDTO();
        expected.setId(2L);
        expected.setStudentName("Pedro");
        expected.setSubjects(new ArrayList<>(List.of(subject2, subject1, subject3)));
        expected.setAverageScore((8D + 4D + 10D)/3);
        expected.setMessage("El alumno Pedro ha obtenido un promedio de 7.33. Puedes mejorar.");

        ObjectWriter writter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer(); // sin el prettyPinter para que no rompa

        String expectedJson = writter.writeValueAsString(expected);
        // Act MockMvcRequestBuilders.get("/analyzeScores/{studentId}",2)
        MvcResult result = this.mockMvc
                .perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}","2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        // Assert
        Assertions.assertEquals(expectedJson, result.getResponse().getContentAsString());
    }

    @Test
    @DisplayName(value = "Promedio mayor a ocho (8)")
    public void analyzeScoresTestOKBest() throws Exception {

        // Arrange
        SubjectDTO subject1 = new SubjectDTO("Fisica", 10D);
        SubjectDTO subject3 = new SubjectDTO("Quimica", 10D);
        SubjectDTO subject2 = new SubjectDTO("Matematica", 10D);
        StudentDTO expected = new StudentDTO();
        expected.setId(3L);
        expected.setStudentName("Lucho");
        expected.setSubjects(new ArrayList<>(List.of(subject2, subject1, subject3)));
        expected.setAverageScore((10D + 10D + 10D)/3);
        expected.setMessage("El alumno Tomas ha obtenido un promedio de 10.00. Felicitaciones!");

        ObjectWriter writter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer(); // sin el prettyPinter para que no rompa

        String expectedJson = writter.writeValueAsString(expected);
        // Act MockMvcRequestBuilders.get("/analyzeScores/{studentId}",2)
        MvcResult result = this.mockMvc
                .perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}","3"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        // Assert
        Assertions.assertEquals(expectedJson, result.getResponse().getContentAsString());
    }
}
