package com.meli.obtenerdiploma.controller.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;

@SpringBootTest
@AutoConfigureMockMvc
class ObtenerDiplomaControllerTest {

    @Autowired
    MockMvc mockMvc;
    List<SubjectDTO> subjects = new ArrayList<>();
    StudentDTO studentDTO = new StudentDTO(
            1L,
            "Roberto",
            "N/A",
            5.0,
            subjects);

    @Test
    void testAnalyzeScoresWhenEntityExist() throws Exception {
        // arrange;
        // act
        ResultActions requestResult = mockMvc
                .perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", studentDTO.getId())
                        .contentType(MediaType.APPLICATION_JSON));
        String responseStringResult = requestResult
                .andReturn()
                .getResponse()
                .getContentAsString();

        // assert
        requestResult.andExpect(MockMvcResultMatchers.status().isOk());

        StudentDTO student = new ObjectMapper()
                .readValue(responseStringResult, StudentDTO.class);
        assertNotNull(student);

    }

    // TODO: debo aprender a ver el resultado del status code de un response luego
    // de hacer test a el error
    @Test
    void testAnalyzeScoresWhenEntityNotExist() {
        // arrange
        // act
        try {
            mockMvc
                    .perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", studentDTO.getId())
                            .contentType(MediaType.APPLICATION_JSON));

        } catch (Exception e) {
            // assert
            // assertEquals(e, e);
            assertEquals(StudentNotFoundException.class, e.getCause().getClass());
        }

    }
}
