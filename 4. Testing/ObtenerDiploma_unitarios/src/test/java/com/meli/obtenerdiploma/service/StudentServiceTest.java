package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {


    @Mock
    StudentDAO studentDAO;
    @Mock
    StudentRepository studentRepository;
    @InjectMocks
    StudentService studentService;

    StudentDTO studentDTO;

    Set<StudentDTO> studentDTOList;

    @BeforeEach
    void setUp() {

        studentDTO = new StudentDTO();
        studentDTO.setStudentName("Juan");
        studentDTO.setId(1L);
        SubjectDTO subject1 = new SubjectDTO("Matemática", 9.0);
        SubjectDTO subject2 = new SubjectDTO("Física", 7.0);
        SubjectDTO subject3 = new SubjectDTO("Química", 6.0);
        studentDTO.setSubjects(List.of(subject1, subject2, subject3));


        studentDTOList = Set.of(studentDTO);
    }

    @Test
    void create() {

        studentService.create(studentDTO);

        // assert
        verify(studentDAO, atLeastOnce()).save(studentDTO);
    }

    @Test
    void read() {

        when(studentDAO.findById(studentDTO.getId())).thenReturn(studentDTO);

        assertEquals(studentDTO, studentService.read(studentDTO.getId()));

    }

    @Test
    void update() {
        studentService.update(studentDTO);
        verify(studentDAO, atLeastOnce()).save(studentDTO);
    }

    @Test
    void delete() {
        studentService.delete(studentDTO.getId());
        verify(studentDAO, atLeastOnce()).delete(studentDTO.getId());
    }

    @Test
    void getAll() {
        when(studentRepository.findAll()).thenReturn(studentDTOList);
        assertEquals(studentDTOList, studentService.getAll());
    }
}