package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegrationTests {

    @Autowired
    MockMvc mockMvc;


    @BeforeAll
    public static void setUpCleanUserDB(){
        TestUtilsGenerator.emptyUsersFile();
    }

    @Test
    public void registerStudentOKTest() throws Exception{

        StudentDTO expectedDTO = new StudentDTO(1L, "Juan", "El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.", 7.333333333333333,
                List.of(
                        new SubjectDTO("Matemática", 9.0),
                        new SubjectDTO("Física", 7.0),
                        new SubjectDTO("Química", 6.0)
                )

        );

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String jsonPayload = writer.writeValueAsString(expectedDTO);


        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(jsonPayload))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();


    }

    @Test
    public void registerStudentNameErrorTest() throws Exception{

        StudentDTO expectedDTO = new StudentDTO(1L, null, "El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.", 7.333333333333333,
                List.of(
                        new SubjectDTO("Matemática", 9.0),
                        new SubjectDTO("Física", 7.0),
                        new SubjectDTO("Química", 6.0)
                )

        );

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String jsonPayload = writer.writeValueAsString(expectedDTO);


        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("MethodArgumentNotValidException"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("El nombre del estudiante no puede estar vacío."))
                .andReturn();


    }

    @Test
    public void registerStudentPayloadTest() throws Exception{

        StudentDTO expectedDTO = new StudentDTO(1L, null, "El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.", 7.333333333333333,
                List.of(
                        new SubjectDTO("Matemática", 9.0),
                        new SubjectDTO("Física", 7.0),
                        new SubjectDTO("Química", 6.0)
                )

        );

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String jsonPayload = writer.writeValueAsString(expectedDTO);


        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content((byte[]) null))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("HttpMessageNotReadableException"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("Required request body is missing: public org.springframework.http.ResponseEntity<?> com.meli.obtenerdiploma.controller.StudentController.registerStudent(com.meli.obtenerdiploma.model.StudentDTO)"))
                .andReturn();


    }


    @Test
    public void getStudentOKTest() throws Exception{

        StudentDTO expectedDTO = new StudentDTO(1L, "Juan", "El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.", 7.333333333333333,
                List.of(
                        new SubjectDTO("Matemática", 9.0),
                        new SubjectDTO("Física", 7.0),
                        new SubjectDTO("Química", 6.0)
                )

        );

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String expectedResponse = writer.writeValueAsString(expectedDTO);


        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(expectedResponse, response.getResponse().getContentAsString(StandardCharsets.UTF_8));

    }

    @Test
    public void getStudentNotFoundTest() throws Exception{
        Long id = 99L;
        mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", id))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("El alumno con Id " + id + " no se encuetra registrado."))
                .andReturn();

    }
    @Test
    public void modifyStudentOKTest() throws Exception{

        StudentDTO expectedDTO = new StudentDTO(1L, "Juan", "El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.", 7.333333333333333,
                List.of(
                        new SubjectDTO("Matemática", 9.0),
                        new SubjectDTO("Física", 7.0),
                        new SubjectDTO("Química", 6.0)
                )

        );

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String jsonPayload = writer.writeValueAsString(expectedDTO);


        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();


    }

    @Test
    public void getStudentListOK() throws Exception{

        List<StudentDTO> expectedList = List.of(
                new StudentDTO(1L, "Juan", "El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.", 7.333333333333333,
                        List.of(
                                new SubjectDTO("Matemática", 9.0),
                                new SubjectDTO("Física", 7.0),
                                new SubjectDTO("Química", 6.0)
                        ))

        );

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String jsonResponse = writer.writeValueAsString(expectedList);

        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(jsonResponse, response.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    public void removeStudentOKTest() throws Exception{

        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

    }
}
