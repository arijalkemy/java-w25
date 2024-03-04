package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.utils.MockBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {
    @Mock
    IObtenerDiplomaService obtenerDiplomaService;

    @Mock
    private IStudentService studentService;

    @InjectMocks
    StudentController studentController;

    @Test
    @DisplayName("Registrar estudiante (Controller) - Éxito")
    public void registerStudentCorrect() {
        StudentDTO paramStudent = MockBuilder.buildParamStudent(1L);

        ResponseEntity<?> result = studentController.registerStudent(paramStudent);

        verify(studentService, atLeast(1)).create(paramStudent);
        assertEquals(ResponseEntity.ok(null), result);
    }

    @Test
    @DisplayName("Buscar estudiante (Controller) - Éxito")
    public void getStudentCorrect() {
        StudentDTO paramStudent = MockBuilder.buildParamStudent(1L);

        when(studentService.read(paramStudent.getId())).thenReturn(paramStudent);
        StudentDTO currentStudent = studentController.getStudent(paramStudent.getId());

        assertEquals(paramStudent, currentStudent);
    }

    @Test
    @DisplayName("Modificar estudiante (Controller) - Éxito")
    public void modifyStudentCorrect() {
        StudentDTO paramStudent = MockBuilder.buildParamStudent(1L);

        ResponseEntity<?> result = studentController.modifyStudent(paramStudent);

        verify(studentService, atLeast(1)).update(paramStudent);
        assertEquals(ResponseEntity.ok(null), result);
    }

    @Test
    @DisplayName("Remover estudiante (Controller) - Éxito")
    public void removeStudentCorrect() {
        StudentDTO paramStudent = MockBuilder.buildParamStudent(1L);

        ResponseEntity<?> result = studentController.removeStudent(paramStudent.getId());

        verify(studentService, atLeast(1)).delete(paramStudent.getId());
        assertEquals(ResponseEntity.ok(null), result);
    }

    @Test
    @DisplayName("Buscar todos los estudiantes (Controller) - Éxito")
    public void getAllStudentsCorrect() {
        Set<StudentDTO> paramStudents = MockBuilder.buildStudentDTOSet();

        when(studentService.getAll()).thenReturn(paramStudents);
        Set<StudentDTO> currentStudents = studentController.listStudents();

        verify(studentService, atLeast(1)).getAll();
        assertEquals(paramStudents, currentStudents);
    }
}
