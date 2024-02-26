package com.meli.obtenerdiploma.integration;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerIntegration {
        @Autowired
        private MockMvc mockMvc;

        static StudentDAO studentDAO = new StudentDAO();

        @BeforeAll
        public static void setup() {
                StudentDTO student = new StudentDTO(1L, "Luna", "mensaje", 9.0, List.of(new SubjectDTO("Math", 9.0)));
                studentDAO.save(student);
        }

        // ----------------------------------------------------- analyzeScores
        // -----------------------------------------------------
        @Test
        public void analyzeScoresOkTest() throws Exception {
                Long studentId = 1L;
                mockMvc
                                .perform(MockMvcRequestBuilders
                                                .get("/analyzeScores/{studentId}", studentId))
                                .andDo(print())
                                .andExpect(status().isOk())
                                .andExpect(content().contentType("application/json"))
                                .andExpect(MockMvcResultMatchers.jsonPath("$.averageScore")
                                                .value(9.0))
                                .andExpect(MockMvcResultMatchers.jsonPath("$.message")
                                                .value("El alumno Luna ha obtenido un promedio de 9.00. Felicitaciones!"))
                                .andReturn();
        }

        @Test
        public void analyzeScoresExceptionTest() throws Exception {
                Long studentId = 999L;
                this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", studentId))
                                .andDo(MockMvcResultHandlers.print())
                                .andExpect(status().isNotFound())
                                .andExpect(content().contentType("application/json"))
                                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("StudentNotFoundException"));
        }
}
