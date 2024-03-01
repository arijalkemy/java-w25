package com.meli.obtenerdiploma;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaIntegrationTests {
    @Autowired
    MockMvc mockMvc;
    StudentDTO studentDTO;
    ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false)
            .writer();

    @BeforeEach
    public void setUp() {
        studentDTO = new StudentDTO();
        studentDTO.setId(1L);
        studentDTO.setStudentName("Juan");
        studentDTO.setSubjects(getThreeSubjects());
        studentDTO.setMessage("El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.");
        studentDTO.setAverageScore(7.333333333333333);
    }

    @Test
    void analyzeScoreOkTest() throws Exception {
        String expected = writer.writeValueAsString(studentDTO);

        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 1L))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(expected, result.getResponse().getContentAsString());
    }

    @Test
    void analyzeScoreStudentNotFoundExceptionTest() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 3L))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.description").value("El alumno con Id 3 no se encuetra registrado."));
    }

    private List<SubjectDTO> getThreeSubjects() {
        return Arrays.asList(
                new SubjectDTO("Matematica", 9.0),
                new SubjectDTO("Fisica", 7.0),
                new SubjectDTO("Quimica", 6.0)
        );
    }

}
