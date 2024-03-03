package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@AutoConfigureMockMvc
@SpringBootTest
public class ObtenerDiplomaControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    IStudentService studentService;

    @Test
    void analyzeScoresOK() throws Exception {
        StudentDTO studentDTOExpected = new StudentDTO(1L, "John Doe", "El alumno John Doe ha obtenido un promedio de 10,00. Felicitaciones!", 10.0,
                List.of( new SubjectDTO("Math", 10.0),new SubjectDTO("Science", 10.0)));
        studentService.create(studentDTOExpected);
        MvcResult respose = mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}",1l))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(serializeStudentDTO(studentDTOExpected),(respose.getResponse().getContentAsString()));
    }
    private String serializeStudentDTO(StudentDTO studentDTO) throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().registerModule(new JavaTimeModule()).writer();
        return ow.writeValueAsString(studentDTO);
    }
}
