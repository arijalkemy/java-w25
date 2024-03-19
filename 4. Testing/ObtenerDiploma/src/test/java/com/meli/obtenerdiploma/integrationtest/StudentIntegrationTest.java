package com.meli.obtenerdiploma.integrationtest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void registerStudentTestOk() throws Exception{

        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Matemática", 5.0) );
        subjects.add(new SubjectDTO("Física", 5.0) );
        subjects.add(new SubjectDTO("Química", 5.0) );
        StudentDTO payloadDto = new StudentDTO(5L, "Camilo", "El alumno Pedro ha obtenido un promedio de 5. Puedes mejorar.",5.0,  subjects);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payloadJson = writer.writeValueAsString(payloadDto);

        this.mockMvc.perform(post("/student/registerStudent")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk());
                //PREGUNTAR LA VALIDACION DEL BODY

    }

    @Test
    void registerStudentTestFail() throws Exception{

        StudentDTO payloadDto = new StudentDTO(0L, "Camilo", "El alumno Pedro ha obtenido un promedio de 5. Puedes mejorar.",5.0,  new ArrayList<>());

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payloadJson = writer.writeValueAsString(payloadDto);

        this.mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.name").value("MethodArgumentNotValidException"));

    }

    @Test
    void getStudentTestOk() throws Exception {

        this.mockMvc.perform(get("/student/getStudent/{id}", "2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.studentName").value("Camilo"))
                .andExpect(jsonPath("$.averageScore").value("5.0"));

    }

    @Test
    void getStudentTestFail() throws Exception {

        this.mockMvc.perform(get("/student/getStudent/{id}", "5"))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("StudentNotFoundException"));

    }

    @Test
    void modifyStudentTestOk() throws Exception{

        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Religion", 10.0) );
        subjects.add(new SubjectDTO("Historia", 10.0) );
        subjects.add(new SubjectDTO("Ciencias politicas", 10.0) );
        StudentDTO payloadDto = new StudentDTO(0L, "Camilo", "",null,  subjects);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payloadJson = writer.writeValueAsString(payloadDto);

        this.mockMvc.perform(post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    void modifyStudentTestFail() throws Exception{

        List<SubjectDTO> subjects = new ArrayList<>();
        StudentDTO payloadDto = new StudentDTO(1L, "Camilo", "",null,  subjects);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payloadJson = writer.writeValueAsString(payloadDto);

        this.mockMvc.perform(post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("MethodArgumentNotValidException"));

    }

    @Test
    void removeStudentTestOk() throws Exception {

        this.mockMvc.perform(get("/student/removeStudent/{id}", "1"))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test  //Falla por errores en el codigo
    void removeStudentTestFail() throws Exception {

        this.mockMvc.perform(get("/student/removeStudent/{id}", "100"))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("StudentNotFoundException"));

    }

    @Test //No hay manejo de excepciones para generar un escenaio negatico
    void listStudentsTestOk() throws Exception {

        MvcResult response = this.mockMvc.perform(get("/student/listStudents"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertTrue(response.getResponse().getContentAsString().length() > 2);

    }

}
