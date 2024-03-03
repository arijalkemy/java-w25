package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class StudentControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    IStudentService studentService;
    @Autowired
    IStudentRepository studentRepository;

    @Test
    void registerStudentOK() throws Exception {
        StudentDTO studentDTO = new StudentDTO(1L, "John Doe", "El alumno John Doe ha obtenido un promedio de 10,00. Felicitaciones!", 10.0,
                List.of(new SubjectDTO("Math", 10.0), new SubjectDTO("Science", 10.0)));
        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(serializeStudentDTO(studentDTO)))
                .andDo(print())
                .andExpect(status().isOk());
   }
    @Test
    void modifyStudentOK() throws Exception {
        StudentDTO studentDTO = new StudentDTO(1L, "Johny Doe", "El alumno John Doe ha obtenido un promedio de 10,00. Felicitaciones!", 10.0,
                List.of(new SubjectDTO("Math", 10.0), new SubjectDTO("Science", 10.0)));
        mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(serializeStudentDTO(studentDTO)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void removeStudentOK() throws Exception {
        StudentDTO studentDTO = new StudentDTO(1L, "Johny Doe", "El alumno John Doe ha obtenido un promedio de 10,00. Felicitaciones!", 10.0,
                List.of(new SubjectDTO("Math", 10.0), new SubjectDTO("Science", 10.0)));
        studentService.create(studentDTO);
        mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}",1L))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getStudentOK() throws Exception {
        StudentDTO studentDTO = new StudentDTO(1L, "Johny Doe", "El alumno John Doe ha obtenido un promedio de 10,00. Felicitaciones!", 10.0,
                List.of(new SubjectDTO("Math", 10.0), new SubjectDTO("Science", 10.0)));
        studentService.create(studentDTO);
        mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}",1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(serializeStudentDTO(studentDTO)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1L));
    }

    @Test
    void listStudentsOK() throws Exception {
        SubjectDTO subject1 = new SubjectDTO("Matemática", 7.0);
        SubjectDTO subject2 = new SubjectDTO("Ciencia", 8.0);
        List<SubjectDTO> listSubjects = new ArrayList<>();
        listSubjects.add(subject1);
        listSubjects.add(subject2);

        StudentDTO studentDTO1 = new StudentDTO(5L,"John Doe","Pasó",8.8,listSubjects);
        StudentDTO studentDTO2 = new StudentDTO(6L,"Marie Cure","Pasó",7.8,listSubjects);
        HashSet<StudentDTO> studentSetExpected = new HashSet<>();
        studentSetExpected.add(studentDTO1);
        studentSetExpected.add(studentDTO2);

        studentService.create(studentDTO1);
        studentService.create(studentDTO2);

        String serializedStudentSetExpected = serializeStudentSet(studentSetExpected);

        mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents")
                .contentType(MediaType.APPLICATION_JSON)
                .content(serializedStudentSetExpected))
                .andExpect(status().isOk());
   }
    private String serializeStudentDTO(StudentDTO studentDTO) throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().registerModule(new JavaTimeModule()).writer();
        return ow.writeValueAsString(studentDTO);
    }
    public static String serializeStudentSet(HashSet<StudentDTO> studentSet) throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().registerModule(new JavaTimeModule()).writer();
        return ow.writeValueAsString(studentSet);
    }
}


