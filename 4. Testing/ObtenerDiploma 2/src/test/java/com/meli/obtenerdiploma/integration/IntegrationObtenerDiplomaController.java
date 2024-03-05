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

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationObtenerDiplomaController {

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

        studentDAO.save(TestUtilsGenerator.generateGoodStudentDto(1L));
        studentDAO.save(TestUtilsGenerator.generateBadStudentDto(2L));
    }

    @Test
    public void testAnalyzeBadScores() throws Exception{
        StudentDTO expectedDto = TestUtilsGenerator.generateBadStudentDto(2L);
        String jsonExpectedDto = writer.writeValueAsString(expectedDto);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 2L))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(jsonExpectedDto));
    }

    @Test
    public void testAnalyzeGoodScores() throws Exception{
        StudentDTO expectedDto = TestUtilsGenerator.generateGoodStudentDto(1L);
        String jsonExpectedDto = writer.writeValueAsString(expectedDto);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 1L))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(jsonExpectedDto));
    }

    @Test
    public void testAnalyzeScoresNotFound() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 3L))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("StudentNotFoundException"));

    }


}
