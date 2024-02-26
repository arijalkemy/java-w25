package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.ErrorDTO;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashSet;
import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class IntegrationStudentTest {

    @Autowired
    MockMvc mockMvc;

    static ObjectWriter writer;

    @BeforeAll
    static void setup(){
        writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE,false).writer();
    }

    @Test
    void registerStudent() throws Exception {

        StudentDTO studentDTO = TestUtilsGenerator.getStudentWithId2(1L);
        String jsonStudent = writer.writeValueAsString(studentDTO);
        mockMvc.perform(post("/student/registerStudent").contentType(MediaType.APPLICATION_JSON).content(jsonStudent))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    void registerStudentEmptyBody() throws Exception {

        StudentDTO studentDTO = new StudentDTO();
        String jsonStudent = writer.writeValueAsString(studentDTO);

        ErrorDTO expectedException = new ErrorDTO("MethodArgumentNotValidException", "La lista de materias no puede estar vacía.");
        String expected = writer.writeValueAsString(expectedException);

        mockMvc.perform(post("/student/registerStudent").contentType(MediaType.APPLICATION_JSON).content(jsonStudent))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(expected));

    }

    @Test
    void getStudentOk() throws Exception {

        StudentDTO studentDTO = TestUtilsGenerator.getStudentWithId2(1L);
        String expected = writer.writeValueAsString(studentDTO);
        mockMvc.perform(get("/student/getStudent/{studentId}",1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(expected))
                .andReturn();

    }


    @Test
    void getNotExistingStudent() throws Exception {
        ErrorDTO errorDTO = new ErrorDTO("StudentNotFoundException","El alumno con Id 3 no se encuetra registrado.");

        String expected = writer.writeValueAsString(errorDTO);
        mockMvc.perform(get("/student/getStudent/{studentId}","3"))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(expected));
    }

    @Test
    void modifyStudentOk() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWithId2(1L);
        String jsonStudent = writer.writeValueAsString(studentDTO);
        mockMvc.perform(post("/student/modifyStudent").contentType(MediaType.APPLICATION_JSON).content(jsonStudent))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void removeStudentException() throws Exception {
        ErrorDTO errorDTO = new ErrorDTO("StudentNotFoundException","El alumno con Id 3 no se encuetra registrado.");

        String expected = writer.writeValueAsString(errorDTO);
        long id = 3L;
        mockMvc.perform(get("/student/removeStudent/{id}", id))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().json(expected));

    }

    @Test
    void listStudentsOk() throws Exception {

        Set<StudentDTO> studentsSet = TestUtilsGenerator.getStudentSet2();
        String expected = writer.writeValueAsString(studentsSet);
        mockMvc.perform(get("/student/listStudents"))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(expected));
    }
}