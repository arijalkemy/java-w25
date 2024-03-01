package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@SpringBootTest
class StudentControllerTest {

    @Mock
    IStudentService studentService;

    @InjectMocks
    StudentController studentController;

    @Test
    public void registerStudentOKTest() {
        // Arrange
        Long id = 1L;
        StudentDTO student = new StudentDTO(id, "Juan", "El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.", 7.333333333333333,
                List.of(
                        new SubjectDTO("Matemática", 9.0),
                        new SubjectDTO("Física", 7.0),
                        new SubjectDTO("Química", 6.0)
                )
        );

        // Act
        studentController.registerStudent(student);

        // Assert
        verify(studentService, atLeastOnce()).create(student);
    }

    @Test
    public void getStudentOkTest() {
        // Arrange
        Long id = 1L;
        StudentDTO student = new StudentDTO(id, "Juan", "El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.", 7.333333333333333,
                List.of(
                        new SubjectDTO("Matemática", 9.0),
                        new SubjectDTO("Física", 7.0),
                        new SubjectDTO("Química", 6.0)
                )
        );

        when(studentService.read(id)).thenReturn(student);

        // Act
        StudentDTO obtained = studentController.getStudent(id);

        // Assert
        verify(studentService, atLeastOnce()).read(id);

        Assertions.assertEquals(student, obtained);
    }

    @Test
    public void modifyStudentOKTest() {
        // Arrange
        Long id = 1L;
        StudentDTO student = new StudentDTO(id, "Juan", "El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.", 7.333333333333333,
                List.of(
                        new SubjectDTO("Matemática", 9.0),
                        new SubjectDTO("Física", 7.0),
                        new SubjectDTO("Química", 6.0)
                )
        );

        // Act
        studentController.modifyStudent(student);

        // Assert
        verify(studentService, atLeastOnce()).update(student);
    }

    @Test
    public void removeStudentOKTest() {
        // Arrange
        Long id = 1L;

        // Act
        studentController.removeStudent(id);

        // Assert
        verify(studentService, atLeastOnce()).delete(id);
    }





}