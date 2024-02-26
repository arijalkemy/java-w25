package com.meli.obtenerdiploma.controller.integrationTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    void getStudentTestOk() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", 250L))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.studentName").value("Pepe"))
                .andReturn();
    }
    @Test
    void getStudentTestNotFount() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", 10000L))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("StudentNotFoundException"))
                .andReturn();
    }

    @Test
    void getAllStudentTestOk() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$").isNotEmpty())
                .andReturn();
    }
    @Test
    void removeStudentTestOk() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", 50L))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(""))
                .andReturn();
    }
    @Test
    void registerStudentTestOk() throws Exception {
        StudentDTO studentDTO = new StudentDTO(
                10L,
                "Claudio",
                null,
                null,
                List.of(
                        new SubjectDTO("Matematicas", 10.0),
                        new SubjectDTO("Quimica", 10.0
                )
        ));

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payloadJson = writer.writeValueAsString(studentDTO);


        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print()).andExpect(status().isOk())
                .andReturn();
    }
    @Test
    void modifyStudentTestOk() throws Exception {
        StudentDTO studentDTO = new StudentDTO(
                10L,
                "Claudia",
                null,
                null,
                List.of(
                        new SubjectDTO("Matematicas", 10.0),
                        new SubjectDTO("Quimica", 10.0
                        )
                ));

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payloadJson = writer.writeValueAsString(studentDTO);


        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print()).andExpect(status().isOk())
                .andReturn();
    }
}
