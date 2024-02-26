package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import com.meli.obtenerdiploma.service.factory.TestFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class StudentServiceTest {

    @Mock
    IStudentDAO studentDAO;
    @Mock
    IStudentRepository studentRepository;
    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;
    @InjectMocks
    com.meli.obtenerdiploma.service.StudentService studentService;
    StudentDTO student;
    long id;

    @BeforeEach
    public void before(){
        student = TestFactory.createStudentDTO();
        id = 1L;
    }

    @Test
    public void shouldCreateAStudentOk(){
        //ARRANGE
        //ACT
        studentService.create(student);
        //ASSERT
        verify(studentDAO, atLeast(1)).save(student);
    }

    @Test
    public void shouldReturnAStudentOk(){
        //ARRANGE
        long id = 1;
        when(studentDAO.findById(id)).thenReturn(student);
        //ACT
        //ASSERT
        assertEquals(student, studentService.read(id));
        verify(studentDAO, atLeast(1)).findById(id);
    }

    @Test
    public void shouldUpdateAStudentOk(){
        //ARRANGE
        StudentDTO studentUpdate = new StudentDTO(id, "Mario","",6.8,
                List.of(new SubjectDTO("Ingles",6.5),
                        new SubjectDTO("Español",7.1)));
        //ACT
        studentService.update(studentUpdate);
        //ASSERT
        verify(studentDAO,atLeast(1)).save(studentUpdate);
    }

    @Test
    public void shouldDeleteAStudentOk(){
        //ARRANGE
        //ACT
        studentService.delete(id);
        //ASSERT
        verify(studentDAO,atLeast(1)).delete(id);
    }

    @Test
    public void shouldReturnTheStudentsOk(){
        //Arrange
        Set<StudentDTO> students = TestFactory.createListStudentDto();
        //ACT
        when(studentRepository.findAll()).thenReturn(students);
        Set<StudentDTO> actual = studentService.getAll();
        //ASSERT
        assertEquals(students, actual);
    }
}
