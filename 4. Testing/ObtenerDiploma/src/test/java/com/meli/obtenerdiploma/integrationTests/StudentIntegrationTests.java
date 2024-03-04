package com.meli.obtenerdiploma.integrationTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.ErrorDTO;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentIntegrationTests {
    @Autowired
    private MockMvc mockMvc;
    private ObjectWriter writer = new ObjectMapper()
            .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
            .writer();

    static StudentDAO studentDAO = new StudentDAO();

    @BeforeAll
    static void init() {
        List<SubjectDTO> subjects = List.of(
                new SubjectDTO("Matematica", 8.0),
                new SubjectDTO("Lengua", 6.0),
                new SubjectDTO("Fisica", 4.0)
        );
        StudentDTO student = new StudentDTO(1L, "Juan", null, null, subjects);
        studentDAO.save(student);
    }

    @Test
    void registerStudentTestOk() throws Exception {
        // /student/registerStudent
        StudentDTO student = new StudentDTO(
                3L,
                "Juan",
                null,
                null,
                List.of(
                        new SubjectDTO("Matematica", 8.0),
                        new SubjectDTO("Lengua", 6.0),
                        new SubjectDTO("Fisica", 4.0)
                ));
        String payload = writer.writeValueAsString(student);

        this.mockMvc.perform(
                        post("/student/registerStudent")
                                .contentType("application/json")
                                .content(payload)
                )
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void registerStudentTestInvalidName() throws Exception {
        // /student/registerStudent
        StudentDTO student = new StudentDTO(
                3L,
                "",
                null,
                null,
                List.of(
                        new SubjectDTO("Matematica", 8.0),
                        new SubjectDTO("Lengua", 6.0),
                        new SubjectDTO("Fisica", 4.0)
                ));
        String payload = writer.writeValueAsString(student);

        this.mockMvc.perform(
                    post("/student/registerStudent")
                    .contentType("application/json")
                    .content(payload)
                ).andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("MethodArgumentNotValidException"));
    }

    @Test
    void registerStudentTestInvalidSubjects() throws Exception {
        // /student/registerStudent
        StudentDTO student = new StudentDTO(
                3L,
                "",
                null,
                null,
                List.of());
        String payload = writer.writeValueAsString(student);

        this.mockMvc.perform(
                        post("/student/registerStudent")
                                .contentType("application/json")
                                .content(payload)
                ).andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("MethodArgumentNotValidException"));
    }

    @Test
    void registerStudentTestInvalidId() throws Exception {
        // /student/registerStudent
        ErrorDTO error = new ErrorDTO(
                "HttpMessageNotReadableException",
                "JSON parse error: Cannot construct instance of `com.meli.obtenerdiploma.model.StudentDTO` (although at least one Creator exists): no String-argument constructor/factory method to deserialize from String value ('student'); nested exception is com.fasterxml.jackson.databind.exc.MismatchedInputException: Cannot construct instance of `com.meli.obtenerdiploma.model.StudentDTO` (although at least one Creator exists): no String-argument constructor/factory method to deserialize from String value ('student')\n at [Source: (PushbackInputStream); line: 1, column: 1]"
        );
        String payload = writer.writeValueAsString("student");

        MvcResult result = this.mockMvc.perform(
                        post("/student/registerStudent")
                                .contentType("application/json")
                                .content(payload)
                ).andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("HttpMessageNotReadableException"))
                .andReturn();

        assertEquals(writer.writeValueAsString(error), result.getResponse().getContentAsString());
    }

    @Test
    void getStudentTestOk() throws Exception {
        // /student/getStudent/{id}
        StudentDTO student = new StudentDTO(
            1L,
            "Juan",
            null,
            null,
            List.of(
                new SubjectDTO("Matematica", 8.0),
                new SubjectDTO("Lengua", 6.0),
                new SubjectDTO("Fisica", 4.0)
            )
        );
        String expected = writer.writeValueAsString(student);

        MvcResult result = this.mockMvc.perform(get("/student/getStudent/{id}",1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(expected, result.getResponse().getContentAsString());
    }
}
