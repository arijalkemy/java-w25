package com.meli.obtenerdiploma.integrationTests;

import com.fasterxml.jackson.databind.ObjectWriter;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaIntegrationTests {
    @Autowired
    private MockMvc mockMvc;

    private static ObjectWriter writer;
    static StudentDAO studentDAO = new StudentDAO();

    @BeforeAll
    static void init() {
        List<SubjectDTO> subjects = List.of(
            new SubjectDTO("Matemática", 8.0),
            new SubjectDTO("Lengua", 6.0),
            new SubjectDTO("Física", 4.0)
        );
        StudentDTO student = new StudentDTO(1L, "Juan", null, null, subjects);
        studentDAO.save(student);
    }

    @Test
    void analyzeScoresTestNoOk() throws Exception {
        // /analyzeScores/{studentId}
        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 0L))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"));
    }

    @Test
    void analyzeScoresTestOk() throws Exception {
        // /analyzeScores/{studentId}
        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 1L))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.studentName").value("Juan"))
                .andExpect(jsonPath("$.averageScore").value(6.0));
    }
}
