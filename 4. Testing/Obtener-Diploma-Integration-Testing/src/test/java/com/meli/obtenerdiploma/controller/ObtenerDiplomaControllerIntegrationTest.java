package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
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

import java.text.DecimalFormat;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    @AfterEach
    public void setUp() {
        TestUtilsGenerator.emptyUsersFile();
    }

    @Test
    public void analyzeScoresTestOk() throws Exception {
        StudentDTO studentDTO = StudentDTO.builder()
                .id(0L)
                .studentName("Martín")
                .subjects(Arrays.asList(
                        new SubjectDTO("Matemáticas", 9.0),
                        new SubjectDTO("Física", 7.0),
                        new SubjectDTO("Química", 9.0)
                ))
                .build();
        TestUtilsGenerator.appendNewStudent(studentDTO);

        studentDTO.setAverageScore(
                studentDTO.getSubjects().stream()
                        .map(SubjectDTO::getScore)
                        .reduce(0.0, Double::sum)/studentDTO.getSubjects().size()
        );
        studentDTO.setMessage("El alumno " + studentDTO.getStudentName() + " ha obtenido un promedio de "
                + new DecimalFormat("#0.00").format(studentDTO.getAverageScore())
                + ". Puedes mejorar.");
        String expectedPayloadResult = TestUtilsGenerator.getJsonPayload(studentDTO);

        MvcResult result = mockMvc.perform(get("/analyzeScores/{studentId}", studentDTO.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        result.getResponse().setCharacterEncoding("UTF-8");

        assertEquals(expectedPayloadResult, result.getResponse().getContentAsString());
    }

    @Test
    public void analyzeScoresTestBadRequestIdAsStringOfCharacters() throws Exception {
        String notExistingId = "string";
        mockMvc.perform(get("/analyzeScores/{studentId}", notExistingId))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    public void analyzeScoresTestNotExistingStudent() throws Exception {
        Long notExistingId = 0L;
        mockMvc.perform(get("/analyzeScores/{studentId}", notExistingId))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.name").value(StudentNotFoundException.class.getSimpleName()))
                .andExpect(jsonPath("$.description").value("El alumno con Id " + notExistingId + " no se encuetra registrado."))
                .andReturn();
    }


}
