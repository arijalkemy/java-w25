package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;
    private ObjectWriter objectMapper;

    public StudentControllerIntegrationTest() {
        this.objectMapper = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

    }

    @BeforeEach
    @AfterEach
    public void loadStudents() {
        TestUtilsGenerator.loadUserFile();
    }

    @Test
    void listStudentIntegrationOk() throws Exception {
        Set<StudentDTO> lista = Set.of(
                TestUtilsGenerator.getExampleStudent()
        );

        String expectedResponse = objectMapper.writeValueAsString(lista);
        MvcResult result = mockMvc
                .perform(get("/student/listStudents"))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        assertEquals(expectedResponse, result.getResponse().getContentAsString());

    }

    @Test
    void registerStudent() throws Exception {
        StudentDTO studentTesst = TestUtilsGenerator.getExampleStudent();
        String jsonStudentDto = this.objectMapper.writeValueAsString(studentTesst);
        mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonStudentDto))
                .andExpect(status().isOk());

    }


    @Test
    void getStudentOkTest() throws Exception {
        StudentDTO expected = TestUtilsGenerator.getExampleStudent();
        String expectedResponse = objectMapper.writeValueAsString(expected);
        MvcResult result = mockMvc.perform(get("/student/getStudent/{id}", 1L))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        assertEquals(expectedResponse, result.getResponse().getContentAsString());

    }

    @Test
    void modifyStudent() throws Exception {
        StudentDTO student = TestUtilsGenerator.getExampleStudent();
        String jsonStudentDto = this.objectMapper.writeValueAsString(student);
        mockMvc.perform(post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonStudentDto))
                .andExpect(status().isOk());

    }


    @Test
    void deleteStudent() throws Exception {
        long id = 1L;
        mockMvc.perform(get("/student/removeStudent/{id}/", id))
                .andExpect(status().isOk());

    }


}
