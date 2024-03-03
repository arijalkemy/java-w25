package com.meli.obtenerdiploma.serviceTest;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.atLeast;


@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @Mock
    IStudentDAO studentDAO;

    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    void testCreateOK(){
        // ARRANGE
        StudentDTO studentExpected = new StudentDTO(1L, "John Doe", "Test", 2.5,
                List.of( new SubjectDTO("Math", 8.0),new SubjectDTO("Science", 9.0)));
        // ACT
        studentService.create(studentExpected);
        // ASSERT
        Mockito.verify(studentDAO).save(studentExpected);
    }

    @Test
    void testReadOK(){
        //ARRANGE
        StudentDTO studentExpected = new StudentDTO(1L, "John Doe", "Test", 2.5,
                List.of( new SubjectDTO("Math", 8.0),new SubjectDTO("Science", 9.0)));
        Mockito.when(studentDAO.findById(1L)).thenReturn(studentExpected);
        //ACT
        StudentDTO readStudent = studentDAO.findById(studentExpected.getId());
        //ASSERT
        assertNotNull(readStudent);
        assertEquals(studentExpected, readStudent);
    }

    @Test
    void readStudentNotFound(){
        //ARRANGE
        Mockito.when(studentDAO.findById(Mockito.anyLong())).thenThrow(StudentNotFoundException.class);
        //ACT - ASSERT
        assertThrows(StudentNotFoundException.class, () -> studentService.read(2L));

    }

    @Test
    void testUpdateOK(){
        // ARRANGE
        StudentDTO studentExpected = new StudentDTO(1L, "John Doe", "Test", 2.5,
                List.of( new SubjectDTO("Math", 8.0),new SubjectDTO("Science", 9.0)));
        // ACT
        studentService.update(studentExpected);
        // ASSERT
        Mockito.verify(studentDAO, atLeast(1)).save(studentExpected);
    }

    @Test
    void testDeleteOK(){
        // ARRANGE
        Long idStudent=1L;
        // ACT
        studentService.delete(idStudent);
        // ASSERT
        Mockito.verify(studentDAO).delete(idStudent);
    }

    @Test
    void testGetAllOK(){
        // ARRANGE
        StudentDTO studentDTO1 = new StudentDTO(1L, "John Doe", "Test1", 2.5,
                List.of( new SubjectDTO("Math", 8.0),new SubjectDTO("Science", 9.0)));
        StudentDTO studentDTO2 = new StudentDTO(2L, "Ariel Gil", "Test2", 3.5,
                List.of( new SubjectDTO("Math", 7.0),new SubjectDTO("Science", 10.0)));

        Set<StudentDTO> setStudentDTOExpected= new HashSet<>();
        setStudentDTOExpected.add(studentDTO1);
        setStudentDTOExpected.add(studentDTO2);

        Mockito.when(studentRepository.findAll()).thenReturn(setStudentDTOExpected);
        // ACT
        Set<StudentDTO> setStudentDTO=studentService.getAll();
        // ASSERT
        assertEquals(setStudentDTOExpected,setStudentDTO);
    }
}
