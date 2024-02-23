package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static com.meli.obtenerdiploma.util.ObjectFactory.createExpectedStudent;
import static com.meli.obtenerdiploma.util.ObjectFactory.createListStudentDTO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class StudentControllerTest {
    @Mock
    IStudentService studentService;

    @InjectMocks
    StudentController studentController;

    @Test
    public void registerStudentTest(){
    //arrange
    StudentDTO student = createExpectedStudent(10L);
    //act
    studentController.registerStudent(student);
    //assert
    verify(studentService, atLeastOnce()).create(student);
    }

    @Test
    public void getStudentTest(){
        //arrange
        StudentDTO student = createExpectedStudent(100L);
        when(studentService.read(student.getId())).thenReturn(student);
        //act
        StudentDTO readStudent = studentController.getStudent(student.getId());
        //assert
        verify(studentService, atLeastOnce()).read(student.getId());
        assertEquals(student, readStudent);
    }

    @Test
    public void modifyStudentTest(){
        //arrange
        StudentDTO student = createExpectedStudent(30L);
        //act
        studentController.modifyStudent(student);
        //assert
        verify(studentService, atLeastOnce()).update(student);
    }

    @Test
    public void removeStudentTest(){
        //arrange
        StudentDTO student = createExpectedStudent(10L);
        //act
        studentController.removeStudent(student.getId());
        //assert
        verify(studentService, atLeastOnce()).delete(student.getId());
    }

    @Test
    public void getAllStudentTest(){
        //arrange
        Set<StudentDTO> students = createListStudentDTO();
        when(studentService.getAll()).thenReturn(students);
        //act
        Set<StudentDTO> readStudents = studentController.listStudents();
        //assert
        verify(studentService, atLeastOnce()).getAll();
        assertEquals(students, readStudents);
    }


}
