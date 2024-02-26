package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.service.factory.TestFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    @Mock
    IStudentService studentService;
    @InjectMocks
    StudentController studentController;
    StudentDTO student;
    long id;

    @BeforeEach
    public void before(){
        student = TestFactory.createStudentDTO();
        id=1L;

    }


    @Test
    public void shouldRegisterStudentOk(){
        //ARRANGE
        ResponseEntity<?> expected = ResponseEntity.ok(null);
        //ACT
        ResponseEntity<?> response = studentController.registerStudent(student);
        verify(studentService, atLeast(1)).create(student);
        //ASSERT
        assertEquals(expected, response);
    }

    @Test
    public void shouldReturnStudentOk(){
        //ARRANGE
        long id = 1L;
        //ACT
        StudentDTO expected = TestFactory.createStudentDTO();
        when(studentService.read(id)).thenReturn(TestFactory.createStudentDTO());
        StudentDTO actual = studentController.getStudent(id);
        verify(studentService,atLeast(1)).read(id);
        //ASSERT
        assertEquals(expected, actual);
    }

    @Test
    public void shouldModifyStudentOk(){
        //ARRANGE
        //ACT
        ResponseEntity<?> actual = studentController.modifyStudent(student);
        verify(studentService,atLeast(1)).update(student);
        //ASSERT
        assertEquals(ResponseEntity.ok(null), studentController.modifyStudent(student));
    }

    @Test
    public void shouldRemoveStudentOk(){
        //ARRANGE
        //ACT
        ResponseEntity<?> actual = studentController.removeStudent(id);
        verify(studentService,atLeast(1)).delete(id);
        //ASSERT
        assertEquals(ResponseEntity.ok(null),actual);
    }

    @Test
    public void shouldReturnStudents(){
        //ARRANGE
        Set<StudentDTO> students = TestFactory.createListStudentDto();
        //ACT
        when(studentService.getAll()).thenReturn(students);
        //ASSERT
        assertEquals(students, studentController.listStudents());
    }

}
