package com.meli.obtenerdiploma.controllerTest;

import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {
    @Mock
    IStudentService studentService;
    @InjectMocks
    StudentController studentController;

    @Test
    void registerStudentOK(){
        //ARRANGE
        StudentDTO studentDTOExpected = new StudentDTO(1L, "John Doe", "Test", 2.5,
                List.of( new SubjectDTO("Math", 10.0),new SubjectDTO("Science", 10.0)));
        // ACT
        studentController.registerStudent(studentDTOExpected);
        // ASSERT
        assertNotNull(studentDTOExpected);
        Mockito.verify(studentService, atLeast(1)).create(studentDTOExpected);
    }

    @Test
    void getStudentOK(){
        //ARRANGE
        StudentDTO studentDTOExpected = new StudentDTO(1L, "John Doe", "Test", 2.5,
                List.of( new SubjectDTO("Math", 10.0),new SubjectDTO("Science", 10.0)));

        when(studentService.read(anyLong())).thenReturn(studentDTOExpected);
        // ACT
        StudentDTO studentDTOActual = studentController.getStudent(1L);
        // ASSERT
        assertNotNull(studentDTOExpected);
        assertEquals(studentDTOExpected, studentDTOActual);
   }
    @Test
    void getStudentNotFoundStudent(){
        //ARRANGE
        Mockito.when(studentService.read(Mockito.anyLong())).thenThrow(StudentNotFoundException.class);
        Assertions.assertThrows(StudentNotFoundException.class, () -> studentController.getStudent(1L));
    }
    @Test
    void modifyStudentOK(){
        //ARRANGE
        StudentDTO studentDTOExpected = new StudentDTO(1L, "John Doe", "Test", 2.5,
                List.of( new SubjectDTO("Math", 10.0),new SubjectDTO("Science", 10.0)));
        // ACT
        studentController.modifyStudent(studentDTOExpected);
        // ASSERT
        Mockito.verify(studentService, atLeast(1)).update(studentDTOExpected);

    }
    @Test
    void removeStudentOK(){
        // ACT
        studentController.removeStudent(1L);
        // ASSERT
        verify(studentService, atLeast(1)).delete(1L);
    }
    @Test
    void listStudentsOK(){
        //ARRANGE
        StudentDTO studentDTOExpected1 = new StudentDTO(1L, "John Doe", "Test", 2.5,
                List.of( new SubjectDTO("Math", 10.0),new SubjectDTO("Science", 10.0)));
        StudentDTO studentDTOExpected2 = new StudentDTO(2L, "Marie Cure", "Test", 2.5,
                List.of( new SubjectDTO("Math", 10.0),new SubjectDTO("Science", 10.0)));
        StudentDTO studentDTOExpected3 = new StudentDTO(3L, "Saray Cull", "Test", 2.5,
                List.of( new SubjectDTO("Math", 10.0),new SubjectDTO("Science", 10.0)));
        Set<StudentDTO> studentsListEspected = new HashSet<>();
        studentsListEspected.add(studentDTOExpected1);
        studentsListEspected.add(studentDTOExpected2);
        studentsListEspected.add(studentDTOExpected3);

        when(studentService.getAll()).thenReturn(studentsListEspected);
        // ACT
        Set<StudentDTO> studentsListActual = studentController.listStudents();
        // ASSERT
        assertEquals(studentsListEspected, studentsListActual);
    }
}
