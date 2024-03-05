package com.meli.obtenerdiploma.integration;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import java.util.ArrayList;
import java.util.List;
import javax.print.attribute.standard.Media;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
  public class StudentControllerIntegration {

  @Autowired
  MockMvc mockMvc;

  static StudentDAO studentDAO = new StudentDAO();

  StudentDTO studentDTO;
  SubjectDTO math;
  SubjectDTO spanish;
  SubjectDTO geometry;

  @BeforeEach
  void beforeEach(){

    math = new SubjectDTO("Matemáticas", 5.0);
    spanish = new SubjectDTO("Español", 6.0);
    geometry = new SubjectDTO("Geometría", 10.0);

    studentDTO = new StudentDTO(33L, "Alejandro", "", 0.0, List.of(
      math, spanish, geometry
    ));

    studentDAO.save(studentDTO);

  }


  @Test
  void registerStudentTest() throws Exception{

    StudentDTO studentDTO1 = new StudentDTO(35L, "Andres", "Hello Mundo", 5.0, List.of(
        new SubjectDTO("Algebra", 0.0), new SubjectDTO("POO", 10.0), new SubjectDTO("Español", 5.0)
    ));
    mockMvc.perform(post("/student/registerStudent")
        .contentType(String.valueOf(MediaType.APPLICATION_JSON))
        .content(TestUtilsGenerator.objectToJson(studentDTO1)))
    .andDo((print()))
    .andExpect(status().isOk()
  }


  @Test
  void deleteStudentTest() throws Exception{
    mockMvc.perform(get("/student/removeStudent/{id}", 33))
        .andDo(print())
        .andExpect(status().isNotFound())
        .andExpect(content().contentType("application/json"));
  }

  @Test
  void getListStudentTestOK() throws Exception{

    mockMvc.perform(get("/listStudents")).andDo(print()).andExpect(status().isOk()).andExpect(
        MockMvcResultMatchers.jsonPath("$").isArray());
  }

  //@Test
  //void getListStudentTestErr() throws Exception{
//
  //  mockMvc.perform(get("/listStudents")).andDo(print()).andExpect(status().isOk()).andExpect(
  //      MockMvcResultMatchers.jsonPath("$[0].id").value(2));
  //}

  @Test
  void getStudentByIdTestOk() throws Exception{
    mockMvc.perform(get("student/getStudent/{id}",33))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(jsonPath("$.studentName").value("Alejandro"));
  }

  @Test
  void getStudentByIdTestFail() throws Exception {
    mockMvc.perform(get("/getStudent/{id}",33))
        .andDo(print())
        .andExpect(status().isNotFound())
        .andExpect(content().contentType("application/json"))
        .andExpect(jsonPath("$.name").value("StudentNotFoundException"));
  }

//  @Test
//  void modifyStudentTestOk() throws  Exception{
//    StudentDTO studentModified = clone();
//    mockMvc.perform(post("/student/modifyStudent")
//            .contentType(MediaType.APPLICATION_JSON)
//            .content(TestUtilsGenerator.objectToJson(studentDTO)));
//  }
}