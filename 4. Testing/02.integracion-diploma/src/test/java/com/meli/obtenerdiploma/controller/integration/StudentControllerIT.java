package com.meli.obtenerdiploma.controller.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.utils.MockBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIT {

    @Autowired
    MockMvc mockMvc;

    static ObjectWriter writer;

    @BeforeAll
    static void setup() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();
    }

    @Test
    @DisplayName("Buscar todos los estudiantes (IT) - Éxito")
    public void getStudentsCorrect() throws Exception {
        this.mockMvc.perform(get("/student/listStudents"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.length()").value(1));
    }

    @Test
    @DisplayName("Buscar estudiante (IT) - Éxito")
    public void getStudentByIdCorrect() throws Exception {
        this.mockMvc.perform(get("/student/getStudent/{studentId}", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.studentName").value("Juan"))
                .andExpect(jsonPath("$.subjects.length()").value(3));
    }

    @Test
    @DisplayName("Buscar estudiantes (IT) - No encontrado")
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

        StudentDTO paramStudent = MockBuilder.buildParamStudent(1L);
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
        StudentDTO paramStudent = MockBuilder.buildModifyParamStudent(1L);
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
        this.mockMvc.perform(get("/student/removeStudent/{studentId}", "1"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
