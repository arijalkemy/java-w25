package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class StudentControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;


    // ----------------------------------------------------- Positive Tests
    @Test
    public void getStudentOK() throws Exception {
        // Arrange
        SubjectDTO subject1 = new SubjectDTO("Fisica", 8D);
        SubjectDTO subject3 = new SubjectDTO("Quimica", 4D);
        SubjectDTO subject2 = new SubjectDTO("Matematica", 10D);
        StudentDTO expected = new StudentDTO();
        expected.setId(2L);
        expected.setStudentName("Lucho");
        expected.setSubjects(new ArrayList<>(List.of(subject2, subject1, subject3)));

        ObjectWriter writter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer(); // sin el prettyPinter para que no rompa

        String expectedJson = writter.writeValueAsString(expected);


        // Act
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", 2))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        // Assert
        Assertions.assertEquals(expectedJson, result.getResponse().getContentAsString());
    }

    @Test
    public void modifyStudentOK() throws Exception { // Post
        // Dejo un json para este test, solo por este caso. Con DB no pasa
        // Arrange
        SubjectDTO subject1 = new SubjectDTO("Fisica", 8D);
        SubjectDTO subject3 = new SubjectDTO("Quimica", 7D);
        SubjectDTO subject2 = new SubjectDTO("Matematica", 10D);
        StudentDTO expected = new StudentDTO();
        expected.setId(2L);
        expected.setStudentName("Lucho");
        expected.setSubjects(new ArrayList<>(List.of(subject2, subject1, subject3)));

        ObjectWriter writter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer(); // sin el prettyPinter para que no rompa

        String jsonPayload = writter.writeValueAsString(expected);
        // Act y Assert ya que es null
        MvcResult result = this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/student/modifyStudent")
                        .contentType("application/json") // Le indico que se espera un json
                        .content(jsonPayload)) // Le indico lo que manda el cliente
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

    }

    @Test
    public void removeStudentOK() throws Exception{ // Delete
        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/student/removeStudent/{id}",1L))
                .andDo(print())
                .andExpect(status().isOk());
    }

    // Dudas:
    // 1    . Se pueden leer con acentos luego de obtener el resultado del mockMvc???
    // 2. Los resultados cambian en base a que test se corre primero. No son indenpendientes

    @Test
    public void listStudentsOK() throws Exception { // get

        SubjectDTO subjectA = new SubjectDTO("Fisica", 8D);
        SubjectDTO subjectB = new SubjectDTO("Quimica", 4D);
        SubjectDTO subjectC = new SubjectDTO("Matematica", 10D);
        List<SubjectDTO> subjects2 = new ArrayList<>(List.<SubjectDTO>of(subjectC, subjectA, subjectB));

        SubjectDTO subjectA1 = new SubjectDTO("Fisica", 10D);
        SubjectDTO subjectB1 = new SubjectDTO("Quimica", 10D);
        SubjectDTO subjectC1 = new SubjectDTO("Matematica", 10D);
        List<SubjectDTO> subjects3 = new ArrayList<>(List.<SubjectDTO>of(subjectC1, subjectA1, subjectB1));

        StudentDTO student2 = new StudentDTO(2L,"Lucho",null, null, subjects2);
        StudentDTO student3 = new StudentDTO(3L, "Martin", null, null, subjects3);

        List<StudentDTO> expected = new ArrayList<>();
        expected.add(student2);
        expected.add(student3);

        ObjectWriter writter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer(); // sin el prettyPinter para que no rompa

        String expectedJson = writter.writeValueAsString(expected);

        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.get(("/student/listStudents")))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)) // Con esto decis que el controller retorna un json
                .andReturn();

        Assertions.assertEquals(expectedJson, result.getResponse().getContentAsString());
    }

    @Test
    public void registerStudentOK() throws Exception { // Post

        // Arrange
        SubjectDTO subject1 = new SubjectDTO("Fisica", 8D);
        SubjectDTO subject3 = new SubjectDTO("Quimica", 7D);
        SubjectDTO subject2 = new SubjectDTO("Matematica", 10D);
        StudentDTO expected = new StudentDTO();
        expected.setId(4L);
        expected.setStudentName("Martin");
        expected.setSubjects(new ArrayList<>(List.of(subject2, subject1, subject3)));

        ObjectWriter writter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer(); // sin el prettyPinter para que no rompa

        String jsonPayload = writter.writeValueAsString(expected);

        MvcResult result = this.mockMvc
                .perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType("application/json") // Con esto le decis que el contreller recibe un json
                        .content(jsonPayload))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    // ----------------------------------------------------- Negative Tests

    @Test
    public void getStudentSadTest() throws Exception { // Post
        // Arrange
       Long idParamFalse = -1L;
        // Act y Assert
        MvcResult result = this.mockMvc
                .perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", idParamFalse))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andReturn();

    }



}
