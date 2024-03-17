package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @Mock
    StudentDAO studentDAO;
    @Mock
    StudentRepository studentRepository;
    @InjectMocks
    StudentService studentService;

    @Test
    public void createOK(){
        StudentDTO expected = new StudentDTO(1L, "Juan", "Cualquier cosa", 3D, List.of(new SubjectDTO("desarrollo", 3D)));

        studentService.create(expected);

        verify(studentDAO, atLeastOnce()).save(expected);
    }

    @Test
    public void readOk(){
        Long id = 1L;
        StudentDTO expected = new StudentDTO(1L, "Juan", "Cualquier cosa", 3D, List.of(new SubjectDTO("desarrollo", 3D)));

        when(studentDAO.findById(id)).thenReturn(expected);

        StudentDTO result = studentService.read(id);

        assertThat(expected).isEqualTo(result);
    }

    @Test
    public void updateOk(){
        StudentDTO student = new StudentDTO(1L, "Juan", "Cualquier cosa", 3D, List.of(new SubjectDTO("desarrollo", 3D)));

        studentService.update(student);

        verify(studentDAO, atLeastOnce()).save(student);
    }

    @Test
    public void deleteOk(){
        Long id = 1L;

        studentService.delete(id);

        verify(studentDAO, atLeastOnce()).delete(id);
    }

    @Test
    public void getAllOk(){
        HashSet<StudentDTO> expected = new HashSet<>(){{
            add(new StudentDTO(1L, "Juan", "Cualquier cosa", 3D, List.of(new SubjectDTO("desarrollo", 3D))));
            add(new StudentDTO(2L, "Ana", "Cualquier cosa", 3D, List.of(new SubjectDTO("desarrollo", 3D))));
            add(new StudentDTO(2L, "Ana", "Cualquier cosa", 3D, List.of(new SubjectDTO("desarrollo", 3D))));
        }};

        when(studentRepository.findAll()).thenReturn(expected);

        Set<StudentDTO> response = studentService.getAll();

        assertThat(expected).isEqualTo(response);
    }
}
