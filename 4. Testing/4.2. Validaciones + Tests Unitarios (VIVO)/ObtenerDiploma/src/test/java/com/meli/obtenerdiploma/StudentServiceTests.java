package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTests {
    @Mock
    StudentDAO studentDAO;
    @Mock
    StudentRepository studentRepository;
    @InjectMocks
    StudentService studentService;

    private StudentDTO createStudent(Long studentId) {
        return new StudentDTO(
            studentId,
            "Juan Perez",
            "Felicitaciones",
            9.5,
            List.of(
                new SubjectDTO("Matematica", 10.0),
                new SubjectDTO("Lengua", 9.0)
            )
        );
    }

    @Test
    void createStudentTest() {
        //Arrange
        Long studentId = 1L;
        StudentDTO stu = createStudent(studentId);
        //Act
        studentService.create(stu);
        //Assert
        verify(studentDAO, atLeast(1)).save(stu);
    }

    @Test
    void readStudentTest() {
        //Arrange
        Long studentId = 1L;
        StudentDTO stu = createStudent(studentId);
        //Act
        when(studentDAO.findById(studentId)).thenReturn(stu);
        //Assert
        assertEquals(stu, studentService.read(studentId));
    }

    @Test
    void updateStudentTest() {
        //Arrange
        Long studentId = 1L;
        StudentDTO stu = createStudent(studentId);
        //Act
        studentService.update(stu);
        //Assert
        verify(studentDAO, atLeast(1)).save(stu);
    }

    @Test
    void deleteStudentTest() {
        //Arrange
        Long studentId = 1L;
        when(studentDAO.delete(studentId)).thenReturn(true);
        //Act
        studentService.delete(studentId);
        //Assert
        verify(studentDAO, atLeast(1)).delete(studentId);
    }

    @Test
    void getAllStudentsTest() {
        //Arrange
        Long studentId = 1L;
        StudentDTO stu = createStudent(studentId);
        //Act
        when(studentRepository.findAll()).thenReturn(Set.of(stu));
        //Assert
        assertEquals(Set.of(stu), studentService.getAll());
    }
}