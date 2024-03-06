package com.meli.obtenerdiploma.unity.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.IStudentService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class StudentControllerUnity {

    IStudentDAO studentDAO;

    @Mock
    IStudentService studentService;

    @InjectMocks
    StudentController studentController;

    @BeforeEach
    @AfterEach
    private void setUp() {
        this.studentDAO = new StudentDAO();
    }

    @Test
    public void registerStudentTest() {
        // Arrange:
        StudentDTO param = new StudentDTO(1L, "", "Sin mensaje", .00, List.of(new SubjectDTO("Matematica", 9.00)));
        // Act:
        studentController.registerStudent(param);
        // Assert:
        verify(studentService, atLeastOnce()).create(param);
    }

    @Test
    public void getStudent() {
        // arrange
        StudentDTO param = new StudentDTO(1L, "", "Sin mensaje", 9.00, List.of(new SubjectDTO("Matematica", 9.00)));
        when(studentService.read(param.getId())).thenReturn(param);
        // act
        StudentDTO readStu = studentController.getStudent(param.getId());
        // assert
        verify(studentService, atLeastOnce()).read(param.getId());
        assertEquals(param, readStu);
    }


    @Test
    public void modifyStudent() {
        // arrange
        StudentDTO param = new StudentDTO(1L, "", "Sin mensaje", 9.00, List.of(new SubjectDTO("Matematica", 9.00)));
        // act
        studentController.modifyStudent(param);
        // assert
        verify(studentService, atLeastOnce()).update(param);
    }

    @Test
    public void removeStudent() {
        // arrange
        StudentDTO param = new StudentDTO(1L, "", "Sin mensaje", 9.00, List.of(new SubjectDTO("Matematica", 9.00)));
        // act
        studentController.removeStudent(param.getId());
        // assert
        verify(studentService, atLeastOnce()).delete(param.getId());
    }
}
