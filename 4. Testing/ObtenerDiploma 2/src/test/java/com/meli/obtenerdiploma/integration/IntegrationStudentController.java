package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
public class IntegrationStudentController {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    StudentDAO studentDAO;
    private static ObjectWriter writer;

    @BeforeAll
    public static void setUpWriter() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer().withDefaultPrettyPrinter();
        TestUtilsGenerator.emptyUsersFile();
    }

    @BeforeEach
    void setUp(){
        TestUtilsGenerator.emptyUsersFile();
        studentDAO.cleanData();
        studentDAO.save(TestUtilsGenerator.generateGoodStudentDto(1L));
        studentDAO.save(TestUtilsGenerator.generateBadStudentDto(2L));
    }

    @Test
    public void registerOk() throws Exception{
        StudentDTO studentDTO = TestUtilsGenerator.generateGoodStudentDto(3L);
        studentDTO.setStudentName("Pepe");
        String studentDtoJson = writer.writeValueAsString(studentDTO);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent").contentType(MediaType.APPLICATION_JSON).content(studentDtoJson))
                .andExpect(status().isOk());
    }

    @Test
    public void registerBadName() throws Exception{
        StudentDTO studentDTO = TestUtilsGenerator.generateGoodStudentDto(2L);
        String studentDtoJson = writer.writeValueAsString(studentDTO);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent").contentType(MediaType.APPLICATION_JSON).content(studentDtoJson))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").value("MethodArgumentNotValidException"));

    }

    @Test
    public void registerBadName2() throws Exception{
        StudentDTO studentDTO = TestUtilsGenerator.generateGoodStudentDto(2L);
        studentDTO.setStudentName("");
        String studentDtoJson = writer.writeValueAsString(studentDTO);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent").contentType(MediaType.APPLICATION_JSON).content(studentDtoJson))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").value("MethodArgumentNotValidException"));

    }

    @Test
    public void registerBadSubjects() throws Exception{
        StudentDTO studentDTO = TestUtilsGenerator.generateGoodStudentDto(2L);
        studentDTO.setSubjects(Collections.emptyList());
        String studentDtoJson = writer.writeValueAsString(studentDTO);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent").contentType(MediaType.APPLICATION_JSON).content(studentDtoJson))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").value("MethodArgumentNotValidException"));

    }

    @Test
    public void getStudentOk() throws Exception{
        StudentDTO studentDTO = TestUtilsGenerator.generateGoodStudentDto(1L);
        String studentDtoJson = writer.writeValueAsString(studentDTO);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(content().json(studentDtoJson));

    }

    @Test
    public void getStudentBad() throws Exception{
        StudentDTO studentDTO = TestUtilsGenerator.generateGoodStudentDto(1L);
        String studentDtoJson = writer.writeValueAsString(studentDTO);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", 20))
                .andExpect(status().isNotFound());
    }

    @Test
    public void modifyOk() throws Exception{
        StudentDTO studentDTO = TestUtilsGenerator.generateGoodStudentDto(2L);
        studentDTO.setStudentName("Pepe");
        String studentDtoJson = writer.writeValueAsString(studentDTO);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent").contentType(MediaType.APPLICATION_JSON).content(studentDtoJson))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteStudentOk() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", 2))
                .andExpect(status().isOk());
    }

    @Test
    public void listStudentsOk() throws Exception{
        StudentDTO studentDTO = TestUtilsGenerator.generateGoodStudentDto(1L);
        StudentDTO studentDTO2 = TestUtilsGenerator.generateBadStudentDto(2L);
        String studentDtoListJson = writer.writeValueAsString(List.of(studentDTO, studentDTO2));
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(studentDtoListJson));
    }

}
