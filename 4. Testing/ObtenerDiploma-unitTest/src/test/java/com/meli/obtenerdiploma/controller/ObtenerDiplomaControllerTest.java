package com.meli.obtenerdiploma.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;

@WebMvcTest(ObtenerDiplomaController.class)
class ObtenerDiplomaControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    IObtenerDiplomaService obtenerDiplomaService;
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
        when(obtenerDiplomaService.analyzeScores(anyLong())).thenReturn(studentDTO);
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
        when(obtenerDiplomaService.analyzeScores(anyLong())).thenThrow(StudentNotFoundException.class);
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
