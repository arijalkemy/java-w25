package com.meli.obtenerdiploma.testsIntegracion;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StudentControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @Order(1)
    void registerStudentTestOk() throws Exception {
        StudentDTO studentDTO = new StudentDTO(6L, "Pepe", "Mensaje", 7.5, List.of(
                new SubjectDTO("Matematica", 8.0),
                new SubjectDTO("Fisica", 7.0)
        ));
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payloadJson = writer.writeValueAsString(studentDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(payloadJson))
                .andDo(print()).andExpect(status().isOk());
                //.andExpect(content().contentTypeCompatibleWith("application/json"))
                //.andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value("Pepe"));
    }

    @Test
    void registerStudentTesSadPath() throws Exception {
        StudentDTO studentDTO = new StudentDTO(6L, "pepe", "Mensaje", 7.5, List.of(
                new SubjectDTO("Matematica", 8.0),
                new SubjectDTO("Fisica", 7.0)
        ));
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payloadJson = writer.writeValueAsString(studentDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print()).andExpect(status().isBadRequest());
               // .andExpect(content().contentTypeCompatibleWith("application/json"));
               //.andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value("Pepe"));
    }

    @Test
    void getStudentTestOk() throws Exception {

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", 6L))
                        .andDo(print()).andExpect(status().isOk())
                        .andExpect(content().contentType("application/json"))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value("Pepe"))
                        .andReturn();
        assertEquals("application/json", mvcResult.getResponse().getContentType());
    }
    @Test
    void modifyStudentTestOk() throws Exception {
        StudentDTO studentDTO = new StudentDTO(6L, "Pepe", "Mensaje", 7.5, List.of(
                new SubjectDTO("Matematica", 8.0),
                new SubjectDTO("Fisica", 7.0)
        ));
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payloadJson = writer.writeValueAsString(studentDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print()).andExpect(status().isOk());
        //.andExpect(content().contentTypeCompatibleWith("application/json"))
        //.andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value("Pepe"));
    }

    @Test
    void getRemoveStudentTestOk() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", 3L))
                .andDo(print()).andExpect(status().isOk())
                .andReturn();

    }

   /* @Test
    void getRemoveStudentTestSadPath() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", 99L))
                .andDo(print()).andExpect(status().isNotFound())
                .andReturn();
    }*/
    @Test
    void getaAllStudentTestOk() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].studentName").value("Pepe"))
                .andReturn();
        assertEquals("application/json", mvcResult.getResponse().getContentType());
    }

    /* @Test
    void getaAllStudentTestSadPath() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$").isEmpty())
                .andReturn();

        assertEquals("application/json", mvcResult.getResponse().getContentType());
    }*/



}
