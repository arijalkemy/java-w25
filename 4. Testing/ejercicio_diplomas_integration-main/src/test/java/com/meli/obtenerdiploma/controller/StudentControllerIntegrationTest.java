package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import javax.swing.text.AbstractDocument;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    private ObjectWriter objectMapper;
    public StudentControllerIntegrationTest(){
        this.objectMapper =  new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

    }
    @Test
    void registerStudent() throws  Exception {

        StudentDTO studentTesst = new StudentDTO();
        studentTesst.setId(1230120312L);
        studentTesst.setStudentName("John Cena");
        studentTesst.setSubjects(List.of(
                new SubjectDTO(
                        "Matematica",
                        7.0
                ),
                new SubjectDTO(
                        "Fisica", 7.0

                ),
                new SubjectDTO("Quimica", 7.0)

        ));

        String jsonStudentDto  = this.objectMapper.writeValueAsString(studentTesst);

        mockMvc.perform(post("registerStudent/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonStudentDto))
                .andExpect(status().isOk());
    }

    @Test
    void listStudentIntegrationOk() throws Exception{
        List<StudentDTO> lista = List.of(
                new StudentDTO(
                        1L,
                        "Juan",
                        "El alumno Juan ha obtenido un promedio de 7.00. Puedes mejorar.",
                        7.0,
                        List.of(
                                new SubjectDTO(
                                        "Matematica",
                                        7.0
                                ),
                                new SubjectDTO(
                                        "Fisica", 7.0

                                ),
                                new SubjectDTO("Quimica", 7.0)
                        )
                )
        );

        String expectedResponse = objectMapper.writeValueAsString(lista);
        MvcResult result = mockMvc
                .perform(get("/listStudents"))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andReturn()
                ;
        assertEquals(expectedResponse, result.getResponse().getContentAsString());

    }
}
