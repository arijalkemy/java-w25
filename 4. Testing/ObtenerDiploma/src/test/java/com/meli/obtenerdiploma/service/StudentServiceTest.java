package com.meli.obtenerdiploma.service;

import static org.junit.jupiter.api.Assertions.*;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
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
class StudentServiceTest {

    @Mock
    StudentDAO studentDAO;

    @Mock
    StudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    private StudentDTO studentDto;

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
    void createOk() {
        studentService.create(studentDto);
        verify(studentDAO, atLeastOnce()).save(studentDto);
    }

    @Test
    void read() {
        when(studentDAO.findById(studentDto.getId())).thenReturn(studentDto);
        assertEquals(studentDto, studentService.read(studentDto.getId()));
    }

    @Test
    void update() {
        studentService.update(studentDto);
        verify(studentDAO, atLeastOnce()).save(studentDto);
    }

    @Test
    void delete() {
        studentService.delete(studentDto.getId());
        verify(studentDAO, atLeastOnce()).delete(studentDto.getId());
    }

    @Test
    void getAll() {
        when(studentRepository.findAll()).thenReturn(Set.of(studentDto));
        assertEquals(Set.of(studentDto), studentService.getAll());
    }
}