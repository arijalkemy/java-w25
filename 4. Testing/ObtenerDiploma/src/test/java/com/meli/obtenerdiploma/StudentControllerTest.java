package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Set;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class StudentControllerTest {
    @Mock
    private IStudentService studentService;

    @InjectMocks
    private StudentController studentController;

    @Test
    public void registerStudentTest() {
        studentController.registerStudent(Mockito.any());
        Mockito.verify(studentService, Mockito.times(1)).create(Mockito.any());
        Assertions.assertEquals(ResponseEntity.ok(null), studentController.registerStudent(Mockito.any()));
    }

    @Test
    public void getStudentTest() {
        StudentDTO studentDTO = new StudentDTO();
        Mockito.when(studentService.read(1L)).thenReturn(studentDTO);
        StudentDTO devolucion = studentController.getStudent(1L);
        Assertions.assertEquals(studentDTO, devolucion);
    }

    @Test
    public void modifyStudentTest() {
        studentController.modifyStudent(Mockito.any());
        Mockito.verify(studentService, Mockito.times(1)).update(Mockito.any());
        Assertions.assertEquals(ResponseEntity.ok(null), studentController.registerStudent(Mockito.any()));
    }

    @Test
    public void removeStudentTest() {
        studentController.removeStudent(1L);
        Mockito.verify(studentService, Mockito.times(1)).delete(1L);
        Assertions.assertEquals(ResponseEntity.ok(null), studentController.removeStudent(1L));
    }

    @Test
    public void listStudentsTest() {
        StudentDTO studentDTO = new StudentDTO();
        Mockito.when(studentService.getAll()).thenReturn(Set.of(studentDTO));
        Set<StudentDTO> set = studentController.listStudents();
        Assertions.assertTrue(set.contains(studentDTO));
    }
}
