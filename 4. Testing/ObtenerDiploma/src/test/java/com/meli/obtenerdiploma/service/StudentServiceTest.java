package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    StudentDAO studentDAO;

    @Mock
    StudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    public void createStudentOk(){

        //Arrange
        StudentDTO studentDTO = new StudentDTO();
        List<SubjectDTO> subjectDTOS = new ArrayList<>();
        subjectDTOS.add(new SubjectDTO("matematicas",5.0));
        subjectDTOS.add(new SubjectDTO("español",8.0));
        subjectDTOS.add(new SubjectDTO("ingles",9.0));
        studentDTO.setStudentName("Andres");
        studentDTO.setSubjects(subjectDTOS);

        //Act
        studentService.create(studentDTO);

        //Assert
        verify(studentDAO,atLeast(1)).save(any());

    }

    @Test
    void readStudentTest(){

        //Arrange
        Long id = 100L;
        StudentDTO studentDTO = new StudentDTO();
        List<SubjectDTO> subjectDTOS = new ArrayList<>();
        subjectDTOS.add(new SubjectDTO("Religion",5.0));
        subjectDTOS.add(new SubjectDTO("Historia",10.0));
        subjectDTOS.add(new SubjectDTO("Ciencias politicas",10.0));
        studentDTO.setStudentName("Camilo");
        studentDTO.setSubjects(subjectDTOS);

        //Act
        when(studentDAO.findById(anyLong())).thenReturn(studentDTO);
        StudentDTO studentDTOTest = studentService.read(id);

        //Assert
        verify(studentDAO, atLeast(1)).findById(anyLong());
        assertEquals(studentDTO, studentDTOTest);

    }

    @Test
    void updateStudentTest(){

        //Arrange
        StudentDTO studentDTO = new StudentDTO();
        List<SubjectDTO> subjectDTOS = new ArrayList<>();
        subjectDTOS.add(new SubjectDTO("Religion",5.0));
        subjectDTOS.add(new SubjectDTO("Historia",10.0));
        subjectDTOS.add(new SubjectDTO("Ciencias politicas",10.0));
        studentDTO.setStudentName("Camilo");
        studentDTO.setSubjects(subjectDTOS);

        //Act
        studentService.update(studentDTO);

        //Assert
        verify(studentDAO, atLeast(1)).save(studentDTO);

    }

    @Test
    void deleteStudentTest(){

        //Arrange
        Long id = 100L;

        //Act
        studentService.delete(id);

        //Assert
        verify(studentDAO, atLeast(1)).delete(id);
    }

    @Test
    void getAllTest(){

        //Arrange
        StudentDTO studentDTO1 = new StudentDTO();
        List<SubjectDTO> subjectDTO1 = new ArrayList<>();
        subjectDTO1.add(new SubjectDTO("Matemáticas",9.0));
        subjectDTO1.add(new SubjectDTO("Física",7.0));
        subjectDTO1.add(new SubjectDTO("Química",6.0));
        studentDTO1.setStudentName("Juan");
        studentDTO1.setSubjects(subjectDTO1);
        StudentDTO studentDTO2 = new StudentDTO();
        List<SubjectDTO> subjectDTO2 = new ArrayList<>();
        subjectDTO2.add(new SubjectDTO("Matemáticas",10.0));
        subjectDTO2.add(new SubjectDTO("Física",8.0));
        subjectDTO2.add(new SubjectDTO("Química",4.0));
        studentDTO2.setStudentName("Pedro");
        studentDTO2.setSubjects(subjectDTO2);
        Set<StudentDTO> expectedList = new HashSet<>();
        expectedList.add(studentDTO1);
        expectedList.add(studentDTO2);

        //Act
        when(studentRepository.findAll()).thenReturn(expectedList);
        Set <StudentDTO> responseList = studentService.getAll();

        //Assert
        verify(studentRepository, atLeast(1)).findAll();
        assertEquals(expectedList, responseList);

    }
}
