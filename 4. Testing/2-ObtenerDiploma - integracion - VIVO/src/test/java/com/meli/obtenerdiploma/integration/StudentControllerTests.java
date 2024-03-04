package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTests {

    @Autowired
    MockMvc mockMvc;

    ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

    private List<StudentDTO> testData;
    private final String BASE_URL = "/student";

    @BeforeEach
    void generateSetup() {
        testData = TestUtilsGenerator.getSetup();
    }

    @Test
    @DisplayName("RegisterStudent - return: void - parameters: StudentDTO")
    void registerStudentOK() throws Exception {
        // Arrange
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3SubjectsAverageOver9("Juan");
        String requestJson = writer.writeValueAsString(studentDTO);

        // Act + Assert
        mockMvc.perform(post(BASE_URL + "/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson)
                ).andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    @DisplayName("GetStudent - return: StudentDTO - parameters: Long")
    void getStudentOK() throws Exception {
        // Arrange
        StudentDTO studentDTO = TestUtilsGenerator.getStudentDTO_1();
        Long id = studentDTO.getId();
        String expectedJsonStudent = writer.writeValueAsString(studentDTO);

        // Act
        MvcResult result = mockMvc.perform(get(BASE_URL + "/getStudent/{id}", id))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        // Assert
        assertEquals(expectedJsonStudent, result.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    @DisplayName("GetStudent - return: StudentNotFoundException - parameters: Long")
    void getStudentNOT_FOUND() throws Exception {
        // Arrange
        Long id = 999999L;

        // Act + Assert
        mockMvc.perform(get(BASE_URL + "/getStudent/{id}", id))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("StudentNotFoundException"))
                .andExpect(jsonPath("$.description").value("El alumno con Id 999999 no se encuetra registrado."))
                .andReturn();
    }

    @Test
    @DisplayName("ModifyStudent - return: void - parameters: StudentDTO")
    void modifyStudentOK() throws Exception {
        // Arrange
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3SubjectsAverageOver9("Pepe");
        String requestDTO = writer.writeValueAsString(studentDTO);

        // Act + Assert
        mockMvc.perform(post(BASE_URL + "/modifyStudent").contentType(MediaType.APPLICATION_JSON)
                        .content(requestDTO))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    @DisplayName("RemoveStudent - return: void - parameters: Long")
    void removeStudentOK() throws Exception {
        // Arrange
        Long id = 1L;

        // Act + Assert
        mockMvc.perform(get(BASE_URL + "/removeStudent/{id}", id))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    @DisplayName("ListStudents - return: Set<StudentDTO> - parameters: 0")
    void listStudents() throws Exception {
        // Arrange
        Set<StudentDTO> studentsSet = TestUtilsGenerator.getAllStudentsSet();
        String responseJson = writer.writeValueAsString(studentsSet);

        // Act
        MvcResult result = mockMvc.perform(get(BASE_URL + "/listStudents"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        // Assert
        assertEquals(responseJson, result.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }
}
