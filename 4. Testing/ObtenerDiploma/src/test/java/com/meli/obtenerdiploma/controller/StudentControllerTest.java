package com.meli.obtenerdiploma.controller;

import static org.junit.jupiter.api.Assertions.*;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import com.meli.obtenerdiploma.service.StudentService;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentControllerTest {

    @Mock
    StudentService studentService;

    @InjectMocks
    StudentController studentController;

    StudentDTO studentDto;

    @BeforeEach
    void setUp() {
        studentDto = new StudentDTO(
                1L,
                "Juan",
                null,
                7.0,
                List.of(
                        new SubjectDTO("Matematica", 6D),
                        new SubjectDTO("Quimica", 10D))
        );
    }

    @Test
    void registerStudent() {
        studentController.registerStudent(studentDto);
        verify(studentService, atLeastOnce()).create(studentDto);
    }

    @Test
    void getStudent() {
        when(studentController.getStudent(studentDto.getId())).thenReturn(studentDto);
        assertEquals(studentDto, studentController.getStudent(studentDto.getId()));
    }

    @Test
    void modifyStudent() {
        studentController.modifyStudent(studentDto);
        verify(studentService, atLeastOnce()).update(studentDto);
    }

    @Test
    void removeStudent() {
        studentController.removeStudent(studentDto.getId());
        verify(studentService, atLeastOnce()).delete(studentDto.getId());
    }

    @Test
    void listStudents() {
        when(studentService.getAll()).thenReturn(Set.of(studentDto));
        Set<StudentDTO> result = studentController.listStudents();
        assertEquals(Set.of(studentDto), result);
    }
}