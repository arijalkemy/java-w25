package com.meli.obtenerdiploma;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.io.Writer;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PracticaTestIntegracionStudent {
/*
Se requiere crear los tests de integración necesarios para cubrir el comportamiento
de la capa de los controladores ObtenerDiplomaController y StudentController.
 Tener en cuenta múltiples escenarios, incluidos las validaciones, mensajes de error y Excepciones.
 */
    @Autowired
    MockMvc mockMvc;

    @DisplayName("getStudent - HAPPY PATH")
    @Test
    void getStudentTestHappyPath() throws Exception{
        MvcResult mvcResult = mockMvc.perform(get("/student/getStudent/{id}",3L))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("El alumno Edgar ha obtenido un promedio de 8. Puedes mejorar."))
                .andReturn();
    }

    @DisplayName("getStudent - notFound PATH")
    @Test
    void getStudentTestNotFoundPath() throws Exception{
        MvcResult mvcResult = mockMvc.perform(get("/student/getStudent/{id}",-3L))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("StudentNotFoundException"))
                .andReturn();
    }

    @DisplayName("getStudentsList - HAPPY PATH")
    @Test
    void getStudentsListTestHappyPath() throws Exception{
        MvcResult mvcResult = mockMvc.perform(get("/student/listStudents"))
                .andDo(print())
                .andExpect(status().isOk())
                //.andExpect(content().contentType("application/json"))
                //.andExpect(jsonPath("$.message").value(""))
                .andReturn();
    }

    @DisplayName("getStudentsList - FileNotFound PATH")
    @Test
    @Disabled
    void getStudentsListTestFileNotFoundExceptionPath() throws Exception{
        MvcResult mvcResult = mockMvc.perform(get("/student/listStudents"))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("FileNotFoundException"))
                .andReturn();
    }

    @DisplayName("getStudentsList - IOException PATH")
    @Test
    @Disabled
    void getStudentsListTestIOExceptionPath() throws Exception{
        MvcResult mvcResult = mockMvc.perform(get("/student/listStudents"))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("IOException"))
                .andReturn();
    }

    @Test
    @DisplayName("registerStudent-HappyPath")
    void registerStudentOk() throws Exception {
        StudentDTO studentDTO = new StudentDTO(2L, "Mario", "",0.0,
                List.of(new SubjectDTO("Español",7.9),
                        new SubjectDTO("Ingles",7.4)));
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(studentDTO);
        mockMvc.perform(post("/student/registerStudent")
                .contentType("application/json")
                .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    @DisplayName("registerStudent-BadRequest Path")
    void registerStudentBadRequest() throws Exception {
        StudentDTO studentDTO = new StudentDTO(-2L, "mario", "",0.0,
                List.of());
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(studentDTO);
        mockMvc.perform(post("/student/registerStudent")
                .contentType("application/json")
                .content(payloadJson))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }




    @SneakyThrows
    @Test
    @DisplayName("Modify student - HappyPath")
    void updateStudentOK() {
        StudentDTO payLoad = new StudentDTO(2L,"Edgar","",0.0, List.of(
                new SubjectDTO("Programacion", 7.0),
                new SubjectDTO("Algebra",9.0 )));

        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        String stringPayload = writer.writeValueAsString(payLoad);
        mockMvc.perform(
                post("/student/modifyStudent")

                    .contentType(MediaType.APPLICATION_JSON)
                    .content(stringPayload))
                .andDo(print())
                .andExpect(status().isOk());


    }
    @SneakyThrows
    @Test
    @DisplayName("Modify student - Bad Request empty name")
    void updateStudentBadRequest() {
        StudentDTO payLoad = new StudentDTO(-2L,"","",0.0, List.of(
                new SubjectDTO("Programacion", 7.0),
                new SubjectDTO("Algebra",9.0 )));

        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        String stringPayload = writer.writeValueAsString(payLoad);
        mockMvc.perform(
                post("/student/modifyStudent")

                    .contentType(MediaType.APPLICATION_JSON)
                    .content(stringPayload))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    @SneakyThrows
    @DisplayName("Delete Student - Happypath")
    void deleteStudentOK(){
        mockMvc.perform(get("/student/removeStudent/{id}", 2L))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    @SneakyThrows
    @Disabled
    void deleteStudentNoFound(){
        mockMvc.perform(get("/student/removeStudent/{id}", -200000L))
                .andDo(print())
                .andExpect(status().isOk());
    }


}
