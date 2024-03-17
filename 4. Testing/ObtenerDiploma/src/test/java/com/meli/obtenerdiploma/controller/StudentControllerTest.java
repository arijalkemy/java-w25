package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    @Mock
    StudentService studentService;

    @InjectMocks
    StudentController studentController;

    @Test
    public void registerStudent(){
        StudentDTO student = new StudentDTO(1L, "Juan", "", 0D, List.of(new SubjectDTO("matematicas", 3D)));

        studentController.registerStudent(student);

        verify(studentService, atLeastOnce()).create(student);
    }

    @Test
    public void getStudent(){
        Long id = 1L;
        StudentDTO expected = new StudentDTO(1L, "Juan", "", 0D, List.of(new SubjectDTO("matematicas", 3D)));

        when(studentService.read(id)).thenReturn(expected);

        StudentDTO result = studentService.read(id);
        assertThat(expected).isEqualTo(result);
    }

    @Test
    public void modifyStudent(){
        StudentDTO student = new StudentDTO(1L, "Juan", "", 0D, List.of(new SubjectDTO("matematicas", 3D)));

        studentController.modifyStudent(student);

        verify(studentService, atLeastOnce()).update(student);
    }

    @Test
    public void removeStudent(){
        Long id = 1L;

        studentController.removeStudent(id);

        verify(studentService, atLeastOnce()).delete(id);
    }

    @Test
    public void listStudents(){
        HashSet<StudentDTO> expected = new HashSet<>(){{
            add(new StudentDTO(1L, "Juan", "Cualquier cosa", 3D, List.of(new SubjectDTO("desarrollo", 3D))));
            add(new StudentDTO(2L, "Ana", "Cualquier cosa", 3D, List.of(new SubjectDTO("desarrollo", 3D))));
            add(new StudentDTO(2L, "Ana", "Cualquier cosa", 3D, List.of(new SubjectDTO("desarrollo", 3D))));
        }};

        when(studentService.getAll()).thenReturn(expected);

        Set<StudentDTO> response = studentService.getAll();

        assertThat(expected).isEqualTo(response);
    }

    @Test
    public void getStudentNotFound(){
        Long id = 1L;

        when(studentService.read(id)).thenThrow(StudentNotFoundException.class);

        assertThrows(StudentNotFoundException.class, () -> studentController.getStudent(id));
    }


}
