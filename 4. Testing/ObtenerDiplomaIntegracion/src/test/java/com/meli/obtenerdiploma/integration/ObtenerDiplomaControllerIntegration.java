package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectWriter;
import com.meli.obtenerdiploma.model.StudentDTO;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.model.*;

@AutoConfigureMockMvc
@SpringBootTest
public class ObtenerDiplomaControllerIntegration {

  @Autowired
  MockMvc mockMvc;

  static StudentDAO studentDAO = new StudentDAO();

  private static ObjectWriter writer;

  SubjectDTO kahoot;
  SubjectDTO musica;
  SubjectDTO poo;

  StudentDTO student;

  @BeforeEach
  public void beforeEach() {

    kahoot = new SubjectDTO("Kahoot", 7.0);
    musica = new SubjectDTO("Musica", 8.0);
    poo = new SubjectDTO("POO", 10.0);

    student = new StudentDTO(1L, "Juan Álvarez", "Hola mundo", 7.2, List.of(
        kahoot, musica, poo
    ));

    studentDAO.save(student);
  }

  @Test
  void analyzeScoresTestOk()  throws Exception {
    mockMvc.perform(get("/analyzeScores/{studentID}", 1))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(jsonPath("$.studentName").value("Juan Álvarez"));
  }

  @Test
  void analyzeScoresTestNotFoundId() throws Exception {
    mockMvc.perform(get("/analyzeScores/{studentID}", 123))
        .andDo(print())
        .andExpect(status().isNotFound())
        .andExpect(content().contentType("application/json"))
        .andExpect(jsonPath("$.name").value("StudentNotFoundException"));
  }
}