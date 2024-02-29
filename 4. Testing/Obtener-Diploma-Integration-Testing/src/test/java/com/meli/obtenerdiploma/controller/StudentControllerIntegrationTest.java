package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.Arrays;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    @AfterEach
    public void setUp() {
        TestUtilsGenerator.emptyUsersFile();
    }

    @Test
    public void registerStudentTestOk() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Renzo");
        TestUtilsGenerator.appendNewStudent(studentDTO);
        String payloadJson = TestUtilsGenerator.getJsonPayload(studentDTO);

        mockMvc.perform(post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void registerStudentTestWithNoSubjets() throws Exception {
        StudentDTO studentDTO = StudentDTO.builder()
                .id(0L)
                .studentName("Renzo")
                .build();
        TestUtilsGenerator.appendNewStudent(studentDTO);
        String payloadJson = TestUtilsGenerator.getJsonPayload(studentDTO);

        mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").value(MethodArgumentNotValidException.class.getSimpleName()))
                .andExpect(jsonPath("$.description").value("La lista de materias no puede estar vacía."));
    }

    @Test
    public void registerStudentTestWithNoStudentName() throws Exception {
        StudentDTO studentDTO = StudentDTO.builder()
                .id(0L)
                .subjects(Arrays.asList(
                        new SubjectDTO("Matemáticas", 9.0),
                        new SubjectDTO("Física", 7.0),
                        new SubjectDTO("Química", 9.0)
                ))
                .build();
        TestUtilsGenerator.appendNewStudent(studentDTO);
        String payloadJson = TestUtilsGenerator.getJsonPayload(studentDTO);

        mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").value(MethodArgumentNotValidException.class.getSimpleName()))
                .andExpect(jsonPath("$.description").value("El nombre del estudiante no puede estar vacío."));
    }

    @Test
    public void registerStudentTestWrongBody() throws Exception {
        String payloadJson = "{badRequest: 'badRequest'}";
        mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void getStudentTestOk() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Renzo");
        studentDTO.setId(1L);
        String payloadJson = TestUtilsGenerator.getJsonPayload(studentDTO);
        mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print()).andExpect(status().isOk());

        MvcResult result = mockMvc.perform(get("/student/getStudent/{id}", studentDTO.getId()))
                .andDo(print()).andExpect(status().isOk())
                .andReturn();

        result.getResponse().setCharacterEncoding("UTF-8");
        assertEquals(payloadJson, result.getResponse().getContentAsString());
    }

    @Test
    public void getStudentTestNotExistingStudent() throws Exception {
        Long notExistingId = 0L;
        mockMvc.perform(get("/student/getStudent/{id}", notExistingId))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(jsonPath("$.name").value(StudentNotFoundException.class.getSimpleName()))
                .andExpect(jsonPath("$.description").value("El alumno con Id " + notExistingId + " no se encuetra registrado."));
    }

    @Test
    public void getStudentTestBadRequestIdAsStringOfCharacters() throws Exception {
        String notExistingId = "string";
        mockMvc.perform(get("/student/getStudent/{id}", notExistingId))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void modifyStudentTestOk() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Renzo");
        studentDTO.setId(1L);
        String registerStudentPayloadJson = TestUtilsGenerator.getJsonPayload(studentDTO);
        mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(registerStudentPayloadJson))
                .andDo(print()).andExpect(status().isOk());

        studentDTO.setStudentName("Renzo Jacinto");
        String modifyStudentPayloadJson = TestUtilsGenerator.getJsonPayload(studentDTO);
        mockMvc.perform(post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(modifyStudentPayloadJson))
                .andDo(print()).andExpect(status().isOk())
                .andReturn();
        MvcResult result = mockMvc.perform(get("/student/getStudent/{id}", studentDTO.getId()))
                .andDo(print()).andExpect(status().isOk())
                .andReturn();

        result.getResponse().setCharacterEncoding("UTF-8");
        assertEquals(modifyStudentPayloadJson, result.getResponse().getContentAsString());
    }

    @Test
    public void modifyStudentTestNotExistingStudent() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Renzo");
        studentDTO.setId(1L);
        String modifyStudentPayloadJson = TestUtilsGenerator.getJsonPayload(studentDTO);
        mockMvc.perform(post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(modifyStudentPayloadJson))
                .andDo(print()).andExpect(status().isOk());

        MvcResult result = mockMvc.perform(get("/student/getStudent/{id}", studentDTO.getId()))
                .andDo(print()).andExpect(status().isOk())
                .andReturn();

        result.getResponse().setCharacterEncoding("UTF-8");
        assertEquals(modifyStudentPayloadJson, result.getResponse().getContentAsString());
    }

    @Test
    public void removeStudentTestOk() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Renzo");
        studentDTO.setId(1L);
        String registerStudentPayloadJson = TestUtilsGenerator.getJsonPayload(studentDTO);
        mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(registerStudentPayloadJson))
                .andDo(print()).andExpect(status().isOk());

        mockMvc.perform(get("/student/removeStudent/{id}", studentDTO.getId()))
                .andDo(print()).andExpect(status().isOk());
        mockMvc.perform(get("/student/getStudent/{id}", studentDTO.getId()))
                .andDo(print()).andExpect(status().isNotFound());
    }

    @Test
    public void removeStudentTestNotExistingId() throws Exception {
        Long notExistingId = 0L;
        mockMvc.perform(get("/student/removeStudent/{id}", notExistingId))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void listOfStudentsTestOkEmptyList() throws Exception {
        MvcResult result = mockMvc.perform(get("/student/listStudents"))
                .andDo(print()).andExpect(status().isOk())
                .andReturn();

        result.getResponse().setCharacterEncoding("UTF-8");
        assertEquals("[]", result.getResponse().getContentAsString());
    }

    @Test
    public void listOfStudentsTestOk3Students() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Renzo");
        studentDTO.setId(1L);
        Set<StudentDTO> studentDTOSet = Set.of(studentDTO);
        String registerStudentPayloadJson = TestUtilsGenerator.getJsonPayload(studentDTO);
        mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(registerStudentPayloadJson))
                .andDo(print()).andExpect(status().isOk());

        MvcResult result = mockMvc.perform(get("/student/listStudents"))
                .andDo(print()).andExpect(status().isOk())
                .andReturn();

        result.getResponse().setCharacterEncoding("UTF-8");
        String expectedList = TestUtilsGenerator.getJsonPayload(studentDTOSet);
        assertEquals(expectedList, result.getResponse().getContentAsString());
    }

}
