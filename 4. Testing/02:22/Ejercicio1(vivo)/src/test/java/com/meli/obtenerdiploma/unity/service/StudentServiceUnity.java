package com.meli.obtenerdiploma.unity.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.StudentService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class StudentServiceUnity {
    @Mock
    IStudentDAO studentDAO;

    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    // ----------------------------------------------------- create
    // -----------------------------------------------------
    @Test
    public void createOkTest() {
        // Arrange:
        StudentDTO param = new StudentDTO(1L, "Luna", "Sin mensaje", 6.0, List.of(new SubjectDTO("Matematica", 6.0)));
        // Act:
        studentService.create(param);
        // Assert:
        verify(studentDAO, atLeastOnce()).save(param);
    }

    // ----------------------------------------------------- read
    // -----------------------------------------------------
    @Test
    public void readOkTest() {
        // Arrange:
        StudentDTO param = new StudentDTO(1L, "Luna", "Sin mensaje", 6.0, List.of(new SubjectDTO("Matematica", 6.0)));
        when(studentDAO.findById(param.getId())).thenReturn(param);
        // Act:
        StudentDTO readStu = studentService.read(param.getId());
        // Assert:
        verify(studentDAO, atLeastOnce()).findById(param.getId());
        assertEquals(param, readStu);
    }

    @Test
    public void readNotOkTest() {
        // Arrange:
        Long id = 999L;
        // Act && Assert:
        Assertions.assertThrows(StudentNotFoundException.class, () -> studentService.read(id));
        verify(studentDAO, atLeastOnce()).findById(id);
    }

    // ----------------------------------------------------- delete
    // -----------------------------------------------------
    @Test
    public void deleteOkTest() {
        // Arrange:
        StudentDTO param = new StudentDTO(1L, "Luna", "Sin mensaje", 6.0, List.of(new SubjectDTO("Matematica", 6.0)));
        when(studentDAO.delete(param.getId())).thenReturn(true);
        // Act:
        Boolean value = studentService.delete(param.getId());
        // Assert:
        verify(studentDAO, atLeastOnce()).delete(param.getId());
        assertEquals(true, value);
    }

    @Test
    public void deleteNotOkTest() {
        // Arrange:
        StudentDTO param = new StudentDTO(999L, "Luna", "Sin mensaje", 6.0, List.of(new SubjectDTO("Matematica", 6.0)));
        // Act:
        Boolean value = studentService.delete(param.getId());
        // Assert:
        verify(studentDAO, atLeastOnce()).delete(param.getId());
        assertEquals(false, value);
    }

    // ----------------------------------------------------- update
    // -----------------------------------------------------
    @Test
    public void updateOkTest() {
        // Arrange:
        StudentDTO param = new StudentDTO(1L, "Luna", "Sin mensaje", 6.0, List.of(new SubjectDTO("Matematica", 6.0)));
        // Act:
        studentService.update(param);
        // Assert:
        verify(studentDAO, atLeastOnce()).save(param);
    }

}
