package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @Mock
    private StudentDAO studentDAO;
    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @Test
    void createTest_Ok(){
        StudentDTO mockedStudent = new StudentDTO(1L,"Facundo","", 0D, List.of(new SubjectDTO("History",10D)));

        studentService.create(mockedStudent);

        verify(studentDAO, atLeast(1)).save(mockedStudent);
    }

    @Test
    void readTest_Ok(){
        StudentDTO mockedStudent = new StudentDTO(1L,"Facundo","", 0D, List.of(new SubjectDTO("History",10D)));
        when(studentDAO.findById(1L)).thenReturn(mockedStudent);
        StudentDTO obtainedStudent = studentService.read(1L);

        assertThat(obtainedStudent).usingRecursiveComparison().isEqualTo(mockedStudent);
    }

    @Test
    void readTest_NotOk(){
        when(studentDAO.findById(2L)).thenThrow(StudentNotFoundException.class);
        Assertions.assertThrows(StudentNotFoundException.class, ()-> studentService.read(2L));
    }

    @Test
    void updateTest_Ok(){
        StudentDTO mockedStudent = new StudentDTO(1L,"Facundo","", 0D, List.of(new SubjectDTO("History",10D)));

        studentService.update(mockedStudent);

        verify(studentDAO, atLeast(1)).save(mockedStudent);
    }

    @Test
    void deleteTest_Ok(){

        studentService.delete(1L);

        verify(studentDAO, atLeast(1)).delete(1L);
    }
    @Test
    void getAllTest_Ok(){
        StudentDTO mockedStudent1 = new StudentDTO(1L,"Facundo","", 0D, List.of(new SubjectDTO("History",10D)));
        StudentDTO mockedStudent2 = new StudentDTO(1L,"Carlos","", 0D, List.of(new SubjectDTO("History",9D)));
        when(studentRepository.findAll()).thenReturn(Set.of(mockedStudent1,mockedStudent2));
        Set<StudentDTO> obtainedStudents = studentService.getAll();

        assertThat(obtainedStudents).usingRecursiveComparison().isEqualTo(Set.of(mockedStudent1,mockedStudent2));
    }

}
