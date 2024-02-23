package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
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
public class IntegrationTests {
    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter writer;

    SubjectDTO kahoot;
    SubjectDTO musica;
    SubjectDTO poo;
    StudentDTO student;


    @BeforeAll
    public static void setUp() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

    }

    @BeforeEach
    public void beforEach() {
        kahoot = new SubjectDTO("Kahoot", 1.0);
        musica = new SubjectDTO("Musica", 9.0);
        poo =    new SubjectDTO("POO",    2.0);

        student =new StudentDTO(1L, "Anibal","El alumno Anibal ha obtenido un promedio de 4. Puedes mejorar.", 4.00, List.of(kahoot, musica, poo) );

    }

    @Test
    public void analizeScoresTest() throws Exception {

        String userJson = writer.writeValueAsString(student);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}",1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        Assertions.assertEquals(userJson, result.getResponse().getContentAsString());
    }

    @Test
    public void analizeScoresTestNotFound() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}",2))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void analizeScoresTestBadRequest() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}",1.1))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void registerStudentTest() throws Exception {

        String userJson = writer.writeValueAsString(student);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(userJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        Assertions.assertEquals("",result.getResponse().getContentAsString());
    }
}
