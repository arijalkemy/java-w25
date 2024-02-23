package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class StudentServiceTest {

    @Mock
    private IStudentDAO studentDAO;
    @Mock
    private IStudentRepository studentRepository;
    @InjectMocks
    private StudentService studentService;

    @Test
    public void createStudentTest() {
        StudentDTO studentDTO = new StudentDTO();
        studentService.create(studentDTO);
        Mockito.verify(studentDAO, Mockito.times(1)).save(any(StudentDTO.class));
    }

    @Test
    public void readStudentTest() {

        StudentDTO param = new StudentDTO();
        Mockito.when(studentDAO.findById(1L)).thenReturn(param);
        StudentDTO devolucion = studentService.read(1L);
        Assertions.assertEquals(param, devolucion);

    }

    @Test
    public void updateStudentTest() {
        StudentDTO studentDTO = new StudentDTO();
        studentService.update(studentDTO);
        Mockito.verify(studentDAO, Mockito.times(1)).save(any(StudentDTO.class));
    }

    @Test
    public void deleteStudentTest() {
        StudentDTO studentDTO = new StudentDTO();
        studentService.delete(1L);
        Mockito.verify(studentDAO, Mockito.times(1)).delete(1L);
    }

    @Test
    public void getAllStudentsTest() {
        StudentDTO studentDTO = new StudentDTO();
        Mockito.when(studentRepository.findAll()).thenReturn(Set.of(studentDTO));

        Set<StudentDTO> set = studentService.getAll();

        Assertions.assertTrue(set.contains(studentDTO));
    }
}
