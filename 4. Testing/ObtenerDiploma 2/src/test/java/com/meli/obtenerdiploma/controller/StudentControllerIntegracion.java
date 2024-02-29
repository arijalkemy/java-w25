package com.meli.obtenerdiploma.controller;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static com.meli.obtenerdiploma.util.TestUtilsGenerator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import java.io.InputStream;


@SpringBootTest
@AutoConfigureMockMvc

public class StudentControllerIntegracion {

    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    void setUpJson() {
        Set<StudentDTO> loadedData = new HashSet<>();

        ObjectMapper objectMapper = new ObjectMapper();
        File filetoRead, fileToWrite;
        try {
            filetoRead = ResourceUtils.getFile("src/main/resources/users.json");
            fileToWrite = ResourceUtils.getFile("src/test/resources/users.json");
            loadedData = objectMapper.readValue(filetoRead, new TypeReference<Set<StudentDTO>>() {
            });
            objectMapper.writeValue(fileToWrite, loadedData);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your JSON formatting.");
        }
    }

    @Test
    void registerStudentOkTest() throws Exception {
        StudentDTO stu = getStudentWithId(10L);
        ;

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payloadJson = writer.writeValueAsString(stu);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk());
    }


    @Test
    void getStudentOkTest() throws Exception {
        StudentDTO stu = TestUtilsGenerator.getStudentFromDatabase();

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String expectedResponse = writer.writeValueAsString(stu);

        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/student/getStudent/{studentId}", stu.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(expectedResponse, result.getResponse().getContentAsString());
    }


    @Test
    void modifyStudentOkTest() throws Exception {
        StudentDTO stu = getStudentWithId(10L);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String jsonPayload = writer.writeValueAsString(stu);

        mockMvc.perform(post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void removeStudentOkTest() throws Exception {
        Long id = 1L;

        this.mockMvc.perform(delete("/student/removeStudent/{id}", id))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void listStudentsOkTest() throws Exception {
        Set<StudentDTO> expectedDto = getStudentSetFromDatabase();

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String expectedResponse = writer.writeValueAsString(expectedDto);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(expectedResponse, result.getResponse().getContentAsString());
    }
    /*@Test
    void listStudentsOkTest2() throws Exception {
        //Set<StudentDTO> expectedDto = getStudentSet()
        ClassPathResource resource = new ClassPathResource("users.json");
        InputStream inputStream = resource.getInputStream();;

        //
        ObjectMapper objectMapper = new ObjectMapper();
        Set<StudentDTO> data = objectMapper.readValue(inputStream, new TypeReference<Set<StudentDTO>>() {});
        //

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String expectedResponse = writer.writeValueAsString(expectedDto);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(expectedResponse, result.getResponse().getContentAsString());
    }*/

}
//ClassPathResource resource = new ClassPathResource("users.json");
//InputStream inputStream = resource.getInputStream();

//ObjectMapper objectMapper = new ObjectMapper();
//Set<StudentDTO> data = objectMapper.readValue(inputStream, new StudentDTO<Set<StudentDTO>>() {});
