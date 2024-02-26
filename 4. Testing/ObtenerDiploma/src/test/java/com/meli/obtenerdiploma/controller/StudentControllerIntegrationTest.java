package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;
    @Test
    public void listStudentsTestOk() throws Exception {
        String expectedStudentName = "Pedro";
        MvcResult result = mockMvc.perform(get("/student/listStudents"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andReturn();

        assertEquals("application/json",result.getResponse().getContentType());
        //assertEquals(HttpStatus.OK,result.getResponse().getStatus());

    }

    @Test
    public void registerStudentTestOk() throws Exception {
        StudentDTO expectedStudent = new StudentDTO(5L,"Pepito","Todo ok",5.5, List.of(
                new SubjectDTO("Matematicas",5.5)
        ));
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();
        String jsonPayload = writer.writeValueAsString(expectedStudent);
        MvcResult result = mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }
@Test
    public void registerStudentTestError() throws Exception {
        StudentDTO expectedStudent = new StudentDTO(5L,"Pepito","Todo ok",5.5, List.of(
                //new SubjectDTO("Matematicas",5.5)
        ));
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();
        String jsonPayload = writer.writeValueAsString(expectedStudent);

        MvcResult result = mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();

        assertEquals("application/json",result.getResponse().getContentType());
        //assertEquals(HttpStatus.OK,result.getResponse().getStatus());

    }
    @Test
    public void getStudentTestOk() throws Exception {
        StudentDTO expectedStudent = new StudentDTO(5L,"Pepito","Todo ok",5.5, List.of(
                new SubjectDTO("Matematicas",5.5)
        ));
        /*StudentDTO expectedStudent = new StudentDTO(1L,"Juan",null,null, List.of(
                new SubjectDTO("Matematica",9.0),
                new SubjectDTO("Fisica",7.0),
                new SubjectDTO("Quimica",6.0)
        ));*/
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();
        String jsonPayload = writer.writeValueAsString(expectedStudent);

         mockMvc.perform(get("/student/getStudent/{id}",5L))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(jsonPayload));

    }
    @Test
    public void getStudentTestError() throws Exception {
        mockMvc.perform(get("/student/getStudent/{id}",500L))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.description").value("El alumno con Id " + 500L + " no se encuetra registrado."));

    }
    @Test
    public void modifyStudentTestOk() throws Exception {
        StudentDTO expectedStudent = new StudentDTO(500L,"Pepito","Todo ok",5.5, List.of(
                new SubjectDTO("Matematicas",5.5)
        ));
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();
        String jsonPayload = writer.writeValueAsString(expectedStudent);

        MvcResult result = mockMvc.perform(post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

    }
@Test
    public void modifyStudentTestError() throws Exception {
        StudentDTO expectedStudent = new StudentDTO(500L,"pepito","Todo ok",5.5, List.of(
                new SubjectDTO("Matematicas",5.5)
        ));
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();
        String jsonPayload = writer.writeValueAsString(expectedStudent);

        MvcResult result = mockMvc.perform(post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.description").value("El nombre del estudiante debe comenzar con mayuscula."))
                .andReturn();

    }

    @Test
    public void removeStudentTestOk() throws Exception {
        mockMvc.perform(get("/student/removeStudent/{id}",1L))
                .andDo(print())
                .andExpect(status().isOk());
    }


}
