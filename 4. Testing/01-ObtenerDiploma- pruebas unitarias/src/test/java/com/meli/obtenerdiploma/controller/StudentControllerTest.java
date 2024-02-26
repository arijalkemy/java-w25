package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class StudentControllerTest {

    @Mock
    IStudentService studentService;

    @InjectMocks
    StudentController studentController;

    @Test
    public void registerStudentTestOk(){

        StudentDTO studentDTO = new StudentDTO();
        List<SubjectDTO> subjectDTOS = new ArrayList<>();

        subjectDTOS.add(new SubjectDTO("matematicas",5.0));
        subjectDTOS.add(new SubjectDTO("español",8.0));
        subjectDTOS.add(new SubjectDTO("ingles",9.0));

        studentDTO.setStudentName("Andres");
        studentDTO.setSubjects(subjectDTOS);

        ResponseEntity<?> response = studentController.registerStudent(studentDTO);

        verify(studentService,atLeast(1)).create(any());

        assertEquals(HttpStatus.OK,response.getStatusCode());

    }


    @Test
    public void getStudentTestOk(){

        StudentDTO studentDTO = new StudentDTO();
        List<SubjectDTO> subjectDTOS = new ArrayList<>();

        subjectDTOS.add(new SubjectDTO("matematicas",5.0));
        subjectDTOS.add(new SubjectDTO("español",8.0));
        subjectDTOS.add(new SubjectDTO("ingles",9.0));

        studentDTO.setStudentName("Andres");
        studentDTO.setSubjects(subjectDTOS);

        when(studentService.read(anyLong())).thenReturn(studentDTO);



        StudentDTO responseStudent = studentController.getStudent(1L);


        assertEquals(studentDTO,responseStudent);

    }


    @Test
    public void modifyStudentTestOk(){

        StudentDTO studentDTO = new StudentDTO();
        List<SubjectDTO> subjectDTOS = new ArrayList<>();

        subjectDTOS.add(new SubjectDTO("matematicas",5.0));
        subjectDTOS.add(new SubjectDTO("español",8.0));
        subjectDTOS.add(new SubjectDTO("ingles",9.0));

        studentDTO.setStudentName("Andres");
        studentDTO.setSubjects(subjectDTOS);

        ResponseEntity<?> response = studentController.modifyStudent(studentDTO);

        verify(studentService,atLeast(1)).update(studentDTO);

        assertEquals(HttpStatus.OK,response.getStatusCode());

    }

    @Test
    public void removeStudentTestOk(){

        StudentDTO studentDTO = new StudentDTO();
        List<SubjectDTO> subjectDTOS = new ArrayList<>();

        subjectDTOS.add(new SubjectDTO("matematicas",5.0));
        subjectDTOS.add(new SubjectDTO("español",8.0));
        subjectDTOS.add(new SubjectDTO("ingles",9.0));

        studentDTO.setStudentName("Andres");
        studentDTO.setSubjects(subjectDTOS);

        ResponseEntity<?> response = studentController.removeStudent(1L);

        verify(studentService,atLeast(1)).delete(anyLong());

        assertEquals(HttpStatus.OK,response.getStatusCode());

    }

    @Test
    public void listStudentsTestOk(){

        StudentDTO studentDTO = new StudentDTO();
        List<SubjectDTO> subjectDTOS = new ArrayList<>();

        subjectDTOS.add(new SubjectDTO("matematicas",5.0));
        subjectDTOS.add(new SubjectDTO("español",8.0));
        subjectDTOS.add(new SubjectDTO("ingles",9.0));

        studentDTO.setStudentName("Andres");
        studentDTO.setSubjects(subjectDTOS);

        Set<StudentDTO> studentDTOS = new HashSet<>();
        studentDTOS.add(studentDTO);
        studentDTOS.add(studentDTO);
        studentDTOS.add(studentDTO);
        studentDTOS.add(studentDTO);
        studentDTOS.add(studentDTO);

        when(studentService.getAll()).thenReturn(studentDTOS);

        Set<StudentDTO>  response = studentController.listStudents();



        assertTrue(response.size() > 0);

    }







}
