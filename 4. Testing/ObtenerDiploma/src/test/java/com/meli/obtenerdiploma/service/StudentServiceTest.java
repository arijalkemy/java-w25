package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
@SpringBootTest
class StudentServiceTest {

    @Mock
    IStudentDAO iStudentDAO;

    @Mock
    IStudentRepository iStudentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    void create() {
        StudentDTO studentDTO = new StudentDTO();

        studentService.create(studentDTO);

        Mockito.verify(iStudentDAO).save(studentDTO);
    }

    @Test
    void read() {
        //Arrange
        Long searchedId = 1L;
        StudentDTO expectedStudent = new StudentDTO(1L, "nombre", "message", 9.5,
                List.of(new SubjectDTO("Matematicas", 9.0), new SubjectDTO("Ciencias naturales", 10.0)));

        Mockito.when(iStudentDAO.findById(searchedId)).thenReturn(expectedStudent);

        //Act
        StudentDTO foundStudent = studentService.read(searchedId);

        //Assert
        Assertions.assertEquals(expectedStudent, foundStudent);
    }

    @Test
    void update() {
        //Average
        StudentDTO student = new StudentDTO();
        //Act
        studentService.update(student);
        //Assert
        Mockito.verify(iStudentDAO).save(student);

    }

    @Test
    void delete() {
        long testId = 1L;

        studentService.delete(testId);

        Mockito.verify(iStudentDAO).delete(testId);
    }

    @Test
    void getAll() {
        Set<StudentDTO> expectedStudents = new HashSet<>(List.of(
                new StudentDTO(1L, "Testeado 1", "Felicitaciones", 9.5, List.of(
                        new SubjectDTO("Mates", 10.0),
                        new SubjectDTO("Ciencias", 9.0)
                )),
                new StudentDTO(2L, "Testeado 2", "Esfuerzate más", 8.5, List.of(
                        new SubjectDTO("Mates", 8.0),
                        new SubjectDTO("Ciencias", 9.0)
                ))
        ));
        Mockito.when(iStudentRepository.findAll()).thenReturn(expectedStudents);

        Set<StudentDTO> result = studentService.getAll();

        Assertions.assertEquals(expectedStudents, result);
    }
}