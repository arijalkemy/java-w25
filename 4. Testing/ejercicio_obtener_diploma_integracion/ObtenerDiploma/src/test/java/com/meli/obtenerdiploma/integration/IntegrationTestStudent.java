package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
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
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTestStudent {

    @Autowired
    MockMvc mockMvc;

    // Crear y retornar objeto de tipo StudentDTO
    private StudentDTO mockStudent(Long id, String name, List<SubjectDTO> subjects){
        return new StudentDTO(
                id,
                name,
                null,
                null,
                subjects
        );
    }

    // Crear y retornar lista de objetos tipo SubjectDTO
    private List<SubjectDTO> mockSubjects(){
        return Arrays.asList(
                new SubjectDTO("Matemática",9D),
                new SubjectDTO("Física",7D),
                new SubjectDTO("Química",6D)
        );
    }

    // Convertir mock a string
    private String serializableMock(StudentDTO studentDTO) throws JsonProcessingException{
        ObjectWriter writer=new ObjectMapper().writer();
        return writer.writeValueAsString(studentDTO);
    }

    // Convertir mock a string
    private String serializableSet(Set<StudentDTO> listStudents) throws JsonProcessingException{
        ObjectWriter writer=new ObjectMapper().writer();
        return writer.writeValueAsString(listStudents);
    }

    // Integration controllers
    @Test
    void registerStudentOk() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(serializableMock(TestUtilsGenerator.getStudentWith3Subjects("Manuel"))))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void registerStudentBad() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(serializableMock(TestUtilsGenerator.getStudentWith3Subjects(null))))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("El nombre del estudiante no puede estar vacío."));
    }

    @Test
    void getStudentOk() throws Exception{
        MvcResult student=mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", 1L))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andReturn();

        StudentDTO studentDTOExpected=mockStudent(1L, "Manuel", Arrays.asList(
                new SubjectDTO("Matematica",9D),
                new SubjectDTO("Fisica",7D),
                new SubjectDTO("Quimica",6D)));

        System.out.println(studentDTOExpected);

        Assertions.assertEquals(serializableMock(studentDTOExpected), (student.getResponse().getContentAsString()));
    }

    @Test
    void getStudentNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", 19L))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("El alumno con Id 19 no se encuetra registrado."));
    }

    @Test
    void modifyStudentOk() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(serializableMock(TestUtilsGenerator.getStudentWith3Subjects("ManuelV"))))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void removeStudentOk() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", 1L))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void removeStudentNotFound() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", 33L))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("El alumno con Id 33 no se encuetra registrado."));
    }

    @Test
    void listStudentsOk() throws Exception{
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(serializableSet(TestUtilsGenerator.getStudentSet()),mvcResult.getResponse().getContentAsString());
    }

    // Test valids
    @Test
    void registerStudentBlankName() throws Exception{
        StudentDTO studentDTO=TestUtilsGenerator.getStudentWith3Subjects("");

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(serializableMock(studentDTO)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("El nombre del estudiante no puede estar vacío."));
    }

    @Test
    void registerStudentNameTooLong() throws Exception{
        StudentDTO studentDTO=TestUtilsGenerator.getStudentWith3Subjects("manuelsaddsdsaaafaajdadabdaskdabkdajbdadjasdbasdausdadhasfifuiasfbasibfafbaiufabsiufbafbasfasbifabfa");

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(serializableMock(studentDTO)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("La longitud del nombre del estudiante no puede superar los 50 caracteres."));

    }

    @Test
    void modifyStudentBlankName() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("");

        mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON).content(serializableMock(studentDTO)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("El nombre del estudiante no puede estar vacío."));
    }
    @Test
    void modifyStudentWrongName() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("manuel");

        mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON).content(serializableMock(studentDTO)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("El nombre del estudiante debe comenzar con mayúscula."));
    }
}
