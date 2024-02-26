package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;

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

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegration {
        @Autowired
        private MockMvc mockMvc;

        static StudentDAO studentDAO = new StudentDAO();

        @BeforeAll
        public static void setup() {
                StudentDTO student = new StudentDTO(1L, "Luna", "mensaje", 9.0, List.of(new SubjectDTO("Math", 9.0)));
                studentDAO.save(student);
        }

        // ----------------------------------------------------- listStudents
        // -----------------------------------------------------
        @Test
        public void listStudentsOkTest() throws Exception {
                StudentDTO student = new StudentDTO(1L, "Luna", "mensaje", 9.0, List.of(new SubjectDTO("Math", 9.0)));
                List<StudentDTO> expected = List.of(student);
                ObjectMapper mapper = new ObjectMapper();
                String expectedJson = mapper.writeValueAsString(expected);
                MvcResult result = mockMvc
                                .perform(MockMvcRequestBuilders.get(("/student/listStudents")))
                                .andDo(print())
                                .andExpect(status().isOk())
                                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                                .andReturn();
                Assertions.assertEquals(expectedJson, result.getResponse().getContentAsString());
        }

        // ----------------------------------------------------- getStudent
        // -----------------------------------------------------
        @Test
        public void getStudentOkTest() throws Exception {
                Long studentId = 1L;
                mockMvc
                                .perform(MockMvcRequestBuilders
                                                .get("/student/getStudent/{id}", studentId))
                                .andDo(print())
                                .andExpect(status().isOk())
                                .andExpect(content().contentType("application/json"))
                                .andExpect(MockMvcResultMatchers.jsonPath("$.studentName")
                                                .value("Luna"))
                                .andExpect(MockMvcResultMatchers.jsonPath("$.subjects[0].name")
                                                .value("Math"))
                                .andReturn();
        }

        @Test
        public void getStudentNotOkTest() throws Exception {
                Long studentId = 999L;
                mockMvc
                                .perform(MockMvcRequestBuilders
                                                .get("/student/getStudent/{id}", studentId))
                                .andDo(print())
                                .andExpect(status().isNotFound())
                                .andExpect(content().contentType("application/json"))
                                .andExpect(result -> assertTrue(
                                                result.getResolvedException() instanceof StudentNotFoundException))
                                .andExpect(MockMvcResultMatchers.jsonPath("$.name")
                                                .value("StudentNotFoundException"))
                                .andExpect(MockMvcResultMatchers.jsonPath("$.description")
                                                .value("El alumno con Id 999 no se encuetra registrado."));
        }

        // ----------------------------------------------------- registerStudent
        // -----------------------------------------------------
        @Test
        public void registerStudentOkTest() throws Exception {
                StudentDTO studentDto = new StudentDTO(
                                2L,
                                "Messi",
                                "mensaje", 8.50,
                                List.of(new SubjectDTO("Math", 9.0), new SubjectDTO("Science", 8.0)));
                ObjectMapper mapper = new ObjectMapper();
                String StudentDtoJson = mapper.writeValueAsString(studentDto);
                mockMvc.perform(MockMvcRequestBuilders
                                .post("/student/registerStudent")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(StudentDtoJson))
                                .andDo(print())
                                .andExpect(status().isOk());
        }

        @Test
        public void registerStudentNotOkTest() throws Exception {
                StudentDTO studentDto = new StudentDTO(
                                2L,
                                "messi",
                                "mensaje", 8.50,
                                List.of(new SubjectDTO("Math", 9.0), new SubjectDTO("Science", 8.0)));
                ObjectMapper mapper = new ObjectMapper();
                String StudentDtoJson = mapper.writeValueAsString(studentDto);
                mockMvc.perform(MockMvcRequestBuilders
                                .post("/student/registerStudent")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(StudentDtoJson))
                                .andDo(print())
                                .andExpect(status().isBadRequest());
        }

        // ----------------------------------------------------- modifyStudent
        // -----------------------------------------------------
        @Test
        public void modifyStudentOkTest() throws Exception {
                StudentDTO studentDto = new StudentDTO(
                                2L,
                                "No es Messi",
                                "mensaje", 9.0,
                                List.of(new SubjectDTO("Math", 9.0)));
                ObjectMapper mapper = new ObjectMapper();
                String StudentDtoJson = mapper.writeValueAsString(studentDto);
                mockMvc.perform(MockMvcRequestBuilders
                                .post("/student/modifyStudent")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(StudentDtoJson))
                                .andDo(print())
                                .andExpect(status().isOk());
        }

        @Test
        public void modifyStudentNotOkTest() throws Exception {
                StudentDTO studentDto = new StudentDTO(
                                2L,
                                "no es Messi",
                                "mensaje", 9.0,
                                List.of(new SubjectDTO("Math", 9.0)));
                ObjectMapper mapper = new ObjectMapper();
                String StudentDtoJson = mapper.writeValueAsString(studentDto);
                mockMvc.perform(MockMvcRequestBuilders
                                .post("/student/modifyStudent")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(StudentDtoJson))
                                .andDo(print())
                                .andExpect(status().isBadRequest());
        }

        // ----------------------------------------------------- removeStudent
        // -----------------------------------------------------
        @Test
        public void removeStudentOkTest() throws Exception {
                Long studentId = 2L;
                mockMvc
                                .perform(MockMvcRequestBuilders
                                                .get("/student/removeStudent/{id}", studentId))
                                .andDo(print())
                                .andExpect(status().isOk());
        }

}
