package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void registerStudentOK() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON).content(SerializeMock(mockStudent(1L,"Juan Manuel",mockListSubjects()))))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    void registerStudentBlankName() throws Exception {
        StudentDTO studentDTO = mockStudent(1L,"",mockListSubjects());
        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON).content(SerializeMock(studentDTO)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("El nombre del estudiante no puede estar vacío."));
    }
    @Test
    void registerStudentWrongName() throws Exception {
        StudentDTO studentDTO = mockStudent(1L,"juan Manuel",mockListSubjects());
        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON).content(SerializeMock(studentDTO)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("El nombre del estudiante debe comenzar con mayúscula."));
    }
    @Test
    void registerStudentNameTooLong() throws Exception {
        StudentDTO studentDTO = mockStudent(1L,"Juan Manueljasjajsjkandksjandkjsankdjanksjdnakjsndkajnsdk",mockListSubjects());
        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON).content(SerializeMock(studentDTO)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("La longitud del nombre del estudiante no puede superar los 50 caracteres."));
    }
    @Test
    void registerStudentNoSubjects() throws Exception {
        StudentDTO studentDTO = mockStudent(1L,"Juan Manuel",new ArrayList<>());
        studentDTO.setSubjects(new ArrayList<>());
        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON).content(SerializeMock(studentDTO)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("La lista de materias no puede estar vacía."));
    }
    @Test
    void getStudentOK() throws Exception {
        MvcResult respose = mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}",1L))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        StudentDTO studentDTOExpected = mockStudent(1L,"Juan", Arrays.asList(
                new SubjectDTO("Matematica",9D),
                new SubjectDTO("Fisica",7D),
                new SubjectDTO("Quimica",6D)));
        Assertions.assertEquals(SerializeMock(studentDTOExpected),(respose.getResponse().()));
    }
    @Test
    void getStundentNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}",19L))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("El alumno con Id 19 no se encuetra registrado."));
    }
    @Test
    void modifyStudentOK() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON).content(SerializeMock(mockStudent(1L,"Juan Manuel",mockListSubjects()))))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    void modifyStudentBlankName() throws Exception {
        StudentDTO studentDTO = mockStudent(1L,"",mockListSubjects());
        mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON).content(SerializeMock(studentDTO)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("El nombre del estudiante no puede estar vacío."));
    }
    @Test
    void modifyStudentWrongName() throws Exception {
        StudentDTO studentDTO = mockStudent(1L,"juan manuel",mockListSubjects());
        mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON).content(SerializeMock(studentDTO)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("El nombre del estudiante debe comenzar con mayúscula."));
    }
    @Test
    void modifyStudentNotSubjects() throws Exception {
        StudentDTO studentDTO = mockStudent(1L,"Juan Manuel",new ArrayList<>());
        mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON).content(SerializeMock(studentDTO)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("La lista de materias no puede estar vacía."));
    }
    @Test
    void removeStudentOK() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}",5L))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    void removeStudentNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}",19L))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("El alumno con Id 19 no se encuetra registrado."));
    }
    @Test
    void listStudentsOK() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(serializeSetMock(mockSetStudentDTO()),mvcResult.getResponse().getContentAsString());
    }
    private String serializeSetMock(Set<StudentDTO> setStudents) throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer();
        return ow.writeValueAsString(setStudents);
    }
    private String SerializeMock(StudentDTO studentDTO) throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer();
        return ow.writeValueAsString(studentDTO);
    }

    private StudentDTO mockStudent(Long id, String name, List<SubjectDTO> subjects) {
        return new StudentDTO(
                id,
                name,
                null,
                null,
                subjects
        );
    }
    private List<SubjectDTO> mockListSubjects(){
        return Arrays.asList(
                new SubjectDTO("Matemática",9D),
                new SubjectDTO("Física",7D),
                new SubjectDTO("Química",6D));
    }
    private Set<StudentDTO> mockSetStudentDTO(){
        Set<StudentDTO> studentsListMock = new HashSet<>();
        studentsListMock.add(new StudentDTO(
                1L,
                "Juan Manuel",
                "",
                0D,
                Arrays.asList(
                        new SubjectDTO(
                                "Matematicas",
                                10.0
                        ),
                        new SubjectDTO(
                                "Ciencias",
                                10.0
                        )
                )));
        studentsListMock.add(new StudentDTO(
                1L,
                "Juan Manuel",
                "",
                0D,
                Arrays.asList(
                        new SubjectDTO(
                                "Matematicas",
                                10.0
                        ),
                        new SubjectDTO(
                                "Ciencias",
                                10.0
                        )
                )));
        studentsListMock.add(new StudentDTO(
                1L,
                "Juan Manuel",
                "",
                0D,
                Arrays.asList(
                        new SubjectDTO(
                                "Matematicas",
                                10.0
                        ),
                        new SubjectDTO(
                                "Ciencias",
                                10.0
                        )
                )));
        return studentsListMock;
    }
}
