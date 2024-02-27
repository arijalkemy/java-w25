package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.MockBuilder;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class StudentControllerIntTest {
    @Autowired
    MockMvc mockMvc;

    static ObjectWriter writer;

    @BeforeAll
    static void setup() {
        TestUtilsGenerator.appendNewStudent(List.of(TestUtilsGenerator.getStudentWithId(1L), TestUtilsGenerator.getStudentWithId(2L)));

        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();
    }

    @Test
    @DisplayName("Test get all students")
    public void testGetAllStudents() throws Exception {
        this.mockMvc.perform(get("/student/listStudents"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    @DisplayName("Get student by id - success")
    public void testGetStudentByIdSuccess() throws Exception {
        this.mockMvc.perform(get("/student/getStudent/{studentId}", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.studentName").value("student1"))
                .andExpect(jsonPath("$.subjects.length()").value(3));
    }

    @Test
    @DisplayName("Get student by id - not found")
    public void testGetStudentByIdNotFound() throws Exception {
        this.mockMvc.perform(get("/student/getStudent/{studentId}", "3"))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("StudentNotFoundException"))
                .andExpect(jsonPath("$.description").value("El alumno con Id 3 no se encuetra registrado."));
    }

    @Test
    @DisplayName("Registrar estudiante (IT) - Éxito")
    void registerStudentCorrect() throws Exception {

        StudentDTO paramStudent = MockBuilder.buildParamStudent(2L);
        String payloadJson = writer.writeValueAsString(paramStudent);

        mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Modificar estudiante (IT) - Éxito")
    void modifyStudentCorrect() throws Exception {
        StudentDTO paramStudent = MockBuilder.buildModifyParamStudent(2L);
        String payloadJson = writer.writeValueAsString(paramStudent);

        mockMvc.perform(post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Eliminar estudiante (IT) - Éxito")
    public void deleteStudentCorrect() throws Exception {
        this.mockMvc.perform(get("/student/removeStudent/{studentId}", "5"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
