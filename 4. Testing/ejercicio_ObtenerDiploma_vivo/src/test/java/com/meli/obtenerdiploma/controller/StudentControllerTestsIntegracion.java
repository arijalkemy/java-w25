package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class StudentControllerTestsIntegracion {

    @Autowired
    private MockMvc mockMvc; // Inyecta el objeto MockMvc


    @Test
    public void registerStudent() throws Exception {

        SubjectDTO subjectDTO = new SubjectDTO("Matemáticas", 10.0);
        SubjectDTO subjectDTO2 = new SubjectDTO("Lengua", 10.0);
        SubjectDTO subjectDTO3 = new SubjectDTO("Ciencias", 10.0);
        List<SubjectDTO> subjects = Arrays.asList(subjectDTO, subjectDTO2, subjectDTO3);

        StudentDTO payloadDto = new StudentDTO(8L, "Juan", "", 9.1, subjects);
        // Serializa el DTO
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(payloadDto);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk());

        //  .andExpect(content().contentType("application/json"))
        //.andExpect(MockMvcResultMatchers.jsonPath("$.")).value()


    }

    @Test
    public void getStudentTestOk() throws Exception {
        Long id = 1L;
        SubjectDTO subject1 = new SubjectDTO("Matemáticas", 10.0);
        SubjectDTO subject2 = new SubjectDTO("Lengua", 10.0);
        SubjectDTO subject3 = new SubjectDTO("Ciencias", 10.0);
        List<SubjectDTO> subjects = Arrays.asList(subject1, subject2, subject3);
        StudentDTO expectedValue = new StudentDTO(id, "Juan", "", 9.1, subjects);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(expectedValue);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", id))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value("Juan"))
                .andExpect(content().json(json, true));


    }

    @Test
    public void modifyStudentTestOk() throws Exception {
        long id = 1L;
        SubjectDTO subjectDTO = new SubjectDTO("Matemáticas", 7.0);
        SubjectDTO subjectDTO2 = new SubjectDTO("Lengua", 8.0);
        SubjectDTO subjectDTO3 = new SubjectDTO("Ciencias", 10.0);
        List<SubjectDTO> subjects = Arrays.asList(subjectDTO, subjectDTO2, subjectDTO3);

        StudentDTO studentDTO = new StudentDTO(id, "juan2", "Integration Test", 7.50, subjects);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(studentDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent").content(json))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void listStudentsTestOk() throws Exception {
        //ObjectMapper mapper = new ObjectMapper();
        //String json = mapper.writeValueAsString(studentDTO);
        long id = 1L;
        SubjectDTO subjectDTO = new SubjectDTO("Matemáticas", 10.0);
        SubjectDTO subjectDTO2 = new SubjectDTO("Lengua", 10.0);
        SubjectDTO subjectDTO3 = new SubjectDTO("Ciencias", 10.0);
        List<SubjectDTO> subjects = Arrays.asList(subjectDTO, subjectDTO2, subjectDTO3);

        StudentDTO student = new StudentDTO(id, "Juan", "", 9.1, subjects);
        List<StudentDTO> expectedValue = new ArrayList<>();

        expectedValue.add(student);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(expectedValue);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(json));

    }

    @Test
    public void removeStudentTestOk() throws Exception {
        Long id = 1L;
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", id))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void removeStudentTestSadPath() throws Exception {
        Long id =3L;
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", id))
                .andDo(print())
                .andExpect(status().isOk());
    }

}