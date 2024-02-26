package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @Mock
    StudentDAO studentDAO;
    @Mock
    StudentRepository studentRepository;
    @InjectMocks
    StudentService studentService;

    private Long studentId;
    private double averageExpected;
    private StudentDTO studentDTO;

    @BeforeEach
    void setUp() {
        studentId = 1L;
        averageExpected = 7.0;

        studentDTO = new StudentDTO();
        studentDTO.setId(studentId);
        studentDTO.setStudentName("Juan");
        SubjectDTO subject1 = new SubjectDTO("Matemática", 9.0);
        SubjectDTO subject2 = new SubjectDTO("Física", 7.0);
        SubjectDTO subject3 = new SubjectDTO("Química", 5.0);
        studentDTO.setSubjects(Arrays.asList(subject1, subject2, subject3));
    }

    @Test
    void createTestOK() {
        studentService.create(studentDTO);

        verify(studentDAO, times(1)).save(studentDTO);
    }

    @Test
    void createNullStudentDTOTest() {
        assertThrows(IllegalArgumentException.class, () -> studentService.create(null));
    }

    @Test
    void readTestOk() {
        when(studentDAO.findById(studentId)).thenReturn(studentDTO);

        StudentDTO result = studentService.read(studentId);

        assertEquals(studentDTO, result);
    }

    @Test
    void updateTestOk(){
        studentService.update(studentDTO);

        verify(studentDAO, times(1)).save((studentDTO));
    }

    @Test
    void deleteTestOk(){
        studentService.delete(studentId);

        verify(studentDAO, times(1)).delete((studentId));
    }

    @Test
    void getAllTestOk(){
        StudentDTO studentDTO1 = new StudentDTO();
        studentDTO1.setId(4L);
        studentDTO1.setStudentName("Lucas");
        SubjectDTO subject1 = new SubjectDTO("Matemática", 9.0);
        SubjectDTO subject2 = new SubjectDTO("Física", 7.0);
        SubjectDTO subject3 = new SubjectDTO("Química", 5.0);
        studentDTO1.setSubjects(Arrays.asList(subject1, subject2, subject3));

        StudentDTO studentDTO2 = new StudentDTO();
        studentDTO2.setId(2L);
        studentDTO2.setStudentName("Maria");
        SubjectDTO subject4 = new SubjectDTO("Biología", 8.0);
        SubjectDTO subject5 = new SubjectDTO("Física", 6.0);
        SubjectDTO subject6 = new SubjectDTO("Química", 7.0);
        studentDTO2.setSubjects(Arrays.asList(subject4, subject5, subject6));

        StudentDTO studentDTO3 = new StudentDTO();
        studentDTO3.setId(3L);
        studentDTO3.setStudentName("Pedro");
        SubjectDTO subject7 = new SubjectDTO("Matemática", 7.0);
        SubjectDTO subject8 = new SubjectDTO("Física", 8.0);
        SubjectDTO subject9 = new SubjectDTO("Química", 9.0);
        studentDTO3.setSubjects(Arrays.asList(subject7, subject8, subject9));

        Set<StudentDTO> studentDTOList = new HashSet<>();
        studentDTOList.add(studentDTO);
        studentDTOList.add(studentDTO1);
        studentDTOList.add(studentDTO2);
        studentDTOList.add(studentDTO3);

        when(studentRepository.findAll()).thenReturn(studentDTOList);

        Set<StudentDTO> result = studentService.getAll();

        assertEquals(result, studentDTOList);
    }
}
