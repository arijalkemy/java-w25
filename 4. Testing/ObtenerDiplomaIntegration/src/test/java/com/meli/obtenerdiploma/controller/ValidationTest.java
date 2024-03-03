package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class ValidationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void createNotBlankStudentName() throws Exception{
        StudentDTO studentDTO = new StudentDTO(1L, null, "El alumno John Doe ha obtenido un promedio de 10,00. Felicitaciones!", 10.0,
                List.of(new SubjectDTO("Math", 10.0), new SubjectDTO("Science", 10.0)));

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON).content(serializeStudentDTO(studentDTO)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("El nombre del estudiante no puede estar vacío."));
    }
    @Test
    void createSizeStudentName() throws Exception{
        StudentDTO studentDTO = new StudentDTO(1L, "Brhadaranyakopanishadvivekachudamani Errehdikkafaijdioaqwpif", "El alumno John Doe ha obtenido un promedio de 10,00. Felicitaciones!", 10.0,
                List.of(new SubjectDTO("Math", 10.0), new SubjectDTO("Science", 10.0)));

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON).content(serializeStudentDTO(studentDTO)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("La longitud del nombre del estudiante no puede superar los 50 caracteres."));
    }
    @Test
    void createPatternStudentName() throws Exception{
        StudentDTO studentDTO = new StudentDTO(1L, "manuel", "El alumno John Doe ha obtenido un promedio de 10,00. Felicitaciones!", 10.0,
                List.of(new SubjectDTO("Math", 10.0), new SubjectDTO("Science", 10.0)));

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON).content(serializeStudentDTO(studentDTO)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("El nombre del estudiante debe comenzar con mayúscula."));
    }
    @Test
    void createNotEmpySubjects() throws Exception{
        StudentDTO studentDTO = new StudentDTO(1L, "Julian", "El alumno John Doe ha obtenido un promedio de 10,00. Felicitaciones!", 10.0,
                List.of());

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON).content(serializeStudentDTO(studentDTO)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("La lista de materias no puede estar vacía."));
    }
    @Test
    void createNotBlankNameSubject() throws Exception{
        StudentDTO studentDTO = new StudentDTO(1L, "Juan", "El alumno John Doe ha obtenido un promedio de 10,00. Felicitaciones!", 10.0,
                List.of(new SubjectDTO(null, 10.0)));

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON).content(serializeStudentDTO(studentDTO)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("El nombre de la materia no puede estar vacío."));
    }
    @Test
    void createSizeNameSubject() throws Exception{
        StudentDTO studentDTO = new StudentDTO(1L, "Manual", "El alumno John Doe ha obtenido un promedio de 10,00. Felicitaciones!", 10.0,
                List.of(new SubjectDTO("Mathjajajajajajajajajajajajajajajajaapcdfkodkfod", 10.0), new SubjectDTO("Science", 10.0)));

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON).content(serializeStudentDTO(studentDTO)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("La longitud del nombre de la materia no puede superar los 30 caracteres."));
    }
    @Test
    void createPatternNameSubject() throws Exception{
        StudentDTO studentDTO = new StudentDTO(1L, "Manuel", "El alumno John Doe ha obtenido un promedio de 10,00. Felicitaciones!", 10.0,
                List.of(new SubjectDTO("math", 10.0), new SubjectDTO("science", 10.0)));

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON).content(serializeStudentDTO(studentDTO)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("El nombre de la materia debe comenzar con mayúscula."));
    }
    @Test
    void createNotNullNameSubject() throws Exception{
        StudentDTO studentDTO = new StudentDTO(1L, "Juan", "El alumno John Doe ha obtenido un promedio de 10,00. Felicitaciones!", 10.0,
                List.of(new SubjectDTO("Ciencia", null)));

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON).content(serializeStudentDTO(studentDTO)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("La nota de la materia no puede estar vacía."));
    }
    @Test
    void createDcimalMaxNameSubject() throws Exception{
        StudentDTO studentDTO = new StudentDTO(1L, "Juan", "El alumno John Doe ha obtenido un promedio de 10,00. Felicitaciones!", 10.0,
                List.of(new SubjectDTO("Ciencia", 20.0)));

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON).content(serializeStudentDTO(studentDTO)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("La nota máxima de la materia es de 10 pts."));
    }
    @Test
    void createDcimalMinNameSubject() throws Exception{
        StudentDTO studentDTO = new StudentDTO(1L, "Juan", "El alumno John Doe ha obtenido un promedio de 10,00. Felicitaciones!", 10.0,
                List.of(new SubjectDTO("Ciencia", -1.0)));

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON).content(serializeStudentDTO(studentDTO)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("La nota mínima de la materia es de 0 pts."));
    }
    private String serializeStudentDTO(StudentDTO studentDTO) throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().registerModule(new JavaTimeModule()).writer();
        return ow.writeValueAsString(studentDTO);
    }
}
