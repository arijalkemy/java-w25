package com.meli.obtenerdiploma.integrityTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.handler;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
class StudentControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void registerStudentSuccess() throws Exception{
        StudentDTO studentExpected = new StudentDTO(1L, "Juan", "Test", 2.5, List.of( new SubjectDTO("Math", 5.0)));

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer().withDefaultPrettyPrinter();
        String payloadJson = writer.writeValueAsString(studentExpected);

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent").contentType(MediaType.APPLICATION_JSON).content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void registerStudentUnsuccessful() throws Exception{
        StudentDTO studentExpected = new StudentDTO();

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer().withDefaultPrettyPrinter();
        String payloadJson = writer.writeValueAsString(studentExpected);

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent").contentType(MediaType.APPLICATION_JSON).content(payloadJson))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    void getStudentUnsuccessful() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/3"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    void getStudentSuccessful() throws Exception{
        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        StudentDTO studentExpected = new StudentDTO(1L,
                "Juan",
                "El alumno Juan ha obtenido un promedio de 5. Puedes mejorar.",
                5.0,
                List.of( new SubjectDTO("Math", 5.0)));

        String payloadJson = writer.writeValueAsString(studentExpected);

        MvcResult mvc = mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value("Juan"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.averageScore").value(5.0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.subjects").isArray()).andReturn();

        Assertions.assertEquals(payloadJson, mvc.getResponse().getContentAsString());
    }

    @Test
    void modifyStudent() throws Exception {
        StudentDTO studentExpected = new StudentDTO(1L, "Juan Carlos", "Test", 2.5, List.of( new SubjectDTO("Math", 5.0)));

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer().withDefaultPrettyPrinter();
        String payloadJson = writer.writeValueAsString(studentExpected);

        mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent").contentType(MediaType.APPLICATION_JSON).content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void listStudents() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(2));
    }

    @Test
    void removeStudentSuccess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/3"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void removeStudentUnsuccessful() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/3"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
}