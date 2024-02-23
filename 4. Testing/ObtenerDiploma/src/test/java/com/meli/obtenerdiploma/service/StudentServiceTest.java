package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.utils.MockBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    @DisplayName("Crear estudiante (Service) - Éxito")
    void createStudentCorrect() {
        StudentDTO paramStudent = MockBuilder.buildParamStudent(1L);
        studentService.create(paramStudent);

        verify(studentDAO, atLeastOnce()).save(paramStudent);
    }

    @Test
    @DisplayName("Buscar todos los estudiantes (Service) - Éxito")
    void getAllStudentsCorrect() {
        Set<StudentDTO> expectedStudents = MockBuilder.buildStudentDTOSet();
        when(studentRepository.findAll()).thenReturn(expectedStudents);

        Set<StudentDTO> currentStudents = studentService.getAll();

        verify(studentRepository, atLeast(1)).findAll();
        assertEquals(expectedStudents, currentStudents);
    }

    @Test
    @DisplayName("Actualizar estudiante (Service) - Éxito")
    void updateStudentCorrect() {
        StudentDTO paramStudent = MockBuilder.buildParamStudent(2L);
        studentService.update(paramStudent);

        verify(studentDAO, atLeastOnce()).save(paramStudent);
    }

    @Test
    @DisplayName("Eliminar estudiante (Service) - Éxito")
    void deleteStudentCorrect() {
        StudentDTO paramStudent = MockBuilder.buildParamStudent(2L);
        studentService.delete(paramStudent.getId());

        verify(studentDAO, atLeastOnce()).delete(paramStudent.getId());
    }

    @Test
    @DisplayName("Buscar estudiante (Service) - Éxito")
    void readStudentCorrect() {
        StudentDTO paramStudent = MockBuilder.buildParamStudent(1L);
        when(studentDAO.findById(1L)).thenReturn(paramStudent);

        StudentDTO currentStudent = studentService.read(1L);

        verify(studentDAO, atLeastOnce()).findById(1L);
        assertEquals(paramStudent, currentStudent);
    }
}
