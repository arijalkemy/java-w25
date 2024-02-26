package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTestIntegration {

    ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false)
            .writer();

    @Autowired
    MockMvc mockMvc;

    @BeforeAll
    public static void setUp(){
        TestUtilsGenerator.emptyUsersFile();
        TestUtilsGenerator.appendNewStudent(new StudentDTO(1L, "Juan", null, null,
                List.of(new SubjectDTO("Matematica", 9D), new SubjectDTO("Fisica", 7D), new SubjectDTO("Quimica", 6D))));
        TestUtilsGenerator.appendNewStudent(new StudentDTO(2L, "Pedro", null, null,
                List.of(new SubjectDTO("Matematica", 10D), new SubjectDTO("Fisica", 8D), new SubjectDTO("Quimica", 4D))));
        TestUtilsGenerator.appendNewStudent(new StudentDTO(3L, "Jose", null, null,
                List.of(new SubjectDTO("Matematica", 10.0),
                        new SubjectDTO("Fisica", 6.0),
                        new SubjectDTO("Quimica", 5.0))));
    }

    @Test
    void registerStudentTestOk() throws Exception{
        StudentDTO studentDTO = new StudentDTO(3L, "Jose", null, null,
                List.of(new SubjectDTO("Matematica", 10.0),
                        new SubjectDTO("Fisica", 6.0),
                        new SubjectDTO("Quimica", 5.0)));

        String payLoadJson = writer.writeValueAsString(studentDTO);

        MvcResult mvcResult = mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payLoadJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

    }

    @Test
    void registerStudentTestMethodArgNotValid() throws Exception{
        StudentDTO studentDTO = new StudentDTO(3L, "jose", null, null,
                List.of(new SubjectDTO("Matematica", 10.0),
                        new SubjectDTO("Fisica", 6.0),
                        new SubjectDTO("Quimica", 5.0)));

        String payLoadJson = writer.writeValueAsString(studentDTO);

        MvcResult mvcResult = mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payLoadJson))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.description").value("El nombre del estudiante debe comenzar con mayúscula."))
                .andReturn();

    }

    @Test
    void registerStudentTestHttpMessageNotReadableException() throws Exception{

        StudentDTO studentDTO = new StudentDTO(3L, "jose", null, null,
                List.of(new SubjectDTO("Matematica", 10.0),
                        new SubjectDTO("Fisica", 6.0),
                        new SubjectDTO("Quimica", 5.0)));

        String payLoadJson = writer.writeValueAsString(studentDTO);
        payLoadJson =  payLoadJson.replace(",", "");

        MvcResult mvcResult = mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payLoadJson))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.description").value("El Json no tiene un formato adecuado"))
                .andReturn();

    }

    @Test
    void getStudentTestOk() throws Exception{
        StudentDTO studentDTO = new StudentDTO(1L, "Juan", null, null,
                List.of(new SubjectDTO("Matematica", 9.0),
                        new SubjectDTO("Fisica", 7.0),
                        new SubjectDTO("Quimica", 6.0)));

        String payLoadJson = writer.writeValueAsString(studentDTO);

        MvcResult mvcResult = mockMvc.perform(get("/student/getStudent/{id}",1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(payLoadJson,mvcResult.getResponse().getContentAsString());
    }

    @Test
    void modifyStudentOK() throws Exception{
        StudentDTO studentDTO = new StudentDTO(2L, "Juan", null, null,
                List.of(new SubjectDTO("Matematica", 1.0),
                        new SubjectDTO("Fisica", 8.0),
                        new SubjectDTO("Quimica", 7.0)));

        String payLoadJson = writer.writeValueAsString(studentDTO);

        MvcResult mvcResult = mockMvc.perform(post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payLoadJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

    }
    @Test
    void removeStudent() throws Exception{
        MvcResult mvcResult = mockMvc.perform(get("/student/removeStudent/{id}", 6L))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

    }

    @Test
    void listStudentsOK() throws Exception{
        String payLoadJson = "[{\"id\":3,\"studentName\":\"Jose\",\"message\":null,\"averageScore\":null,\"subjects\":[{\"name\":\"Matematica\",\"score\":10.0},{\"name\":\"Fisica\",\"score\":6.0},{\"name\":\"Quimica\",\"score\":5.0}]},{\"id\":2,\"studentName\":\"Pedro\",\"message\":null,\"averageScore\":null,\"subjects\":[{\"name\":\"Matematica\",\"score\":10.0},{\"name\":\"Fisica\",\"score\":8.0},{\"name\":\"Quimica\",\"score\":4.0}]},{\"id\":1,\"studentName\":\"Juan\",\"message\":null,\"averageScore\":null,\"subjects\":[{\"name\":\"Matematica\",\"score\":9.0},{\"name\":\"Fisica\",\"score\":7.0},{\"name\":\"Quimica\",\"score\":6.0}]}]";

        MvcResult mvcResult = mockMvc.perform(get("/student/listStudents"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(payLoadJson,mvcResult.getResponse().getContentAsString());
    }


}

