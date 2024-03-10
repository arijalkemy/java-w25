package com.meli.obtenerdiploma.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
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

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;

@WebMvcTest(StudentController.class)
class StudentControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    IStudentService studentService;
    List<SubjectDTO> subjects = new ArrayList<>();
    StudentDTO studentDTO = new StudentDTO(
            1L,
            "Roberto",
            "N/A",
            5.0,
            subjects);

    @Test
    void testGetStudent() throws Exception {
        // arrange;
        when(studentService.read(studentDTO.getId())).thenReturn(studentDTO);
        // act
        ResultActions requestResult = mockMvc
                .perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", studentDTO.getId())
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

    @Test
    void testListStudents() throws Exception {
        // arrange;
        when(studentService.getAll()).thenReturn(new HashSet<>(Arrays.asList(studentDTO)));
        // act
        ResultActions requestResult = mockMvc
                .perform(MockMvcRequestBuilders.get("/student/listStudents")
                        .contentType(MediaType.APPLICATION_JSON));
        String responseStringResult = requestResult
                .andReturn()
                .getResponse()
                .getContentAsString();

        // assert
        requestResult.andExpect(MockMvcResultMatchers.status().isOk());
        HashSet<StudentDTO> student = new ObjectMapper()
                .readValue(responseStringResult, new TypeReference<HashSet<StudentDTO>>() {
                });
        assertNotNull(student);

    }

    @Test
    void testModifyStudent() throws Exception {
        // arrange;
        doNothing().when(studentService).update(any(StudentDTO.class));
        String requestData = new ObjectMapper().writeValueAsString(studentDTO);
        // act
        ResultActions requestResult = mockMvc
                .perform(MockMvcRequestBuilders.post("/student/modifyStudent", studentDTO.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding(StandardCharsets.UTF_8)
                        .content(requestData)
                        .accept(MediaType.APPLICATION_JSON));

        // assert
        requestResult.andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testRegisterStudent() throws Exception {
        // arrange;
        doNothing().when(studentService).create(any(StudentDTO.class));
        String requestData = new ObjectMapper().writeValueAsString(studentDTO);
        // act
        ResultActions requestResult = mockMvc
                .perform(MockMvcRequestBuilders.post("/student/registerStudent", studentDTO.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding(StandardCharsets.UTF_8)
                        .content(requestData)
                        .accept(MediaType.APPLICATION_JSON));

        // assert
        requestResult.andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testRemoveStudent() throws Exception {
        // arrange;
        doNothing().when(studentService).delete(studentDTO.getId());
        // act
        ResultActions requestResult = mockMvc
                .perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", studentDTO.getId())
                        .contentType(MediaType.APPLICATION_JSON));

        // assert
        requestResult.andExpect(MockMvcResultMatchers.status().isOk());
    }
}
