package com.meli.obtenerdiploma.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.junit.jupiter.MockitoExtension;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    IStudentDAO studentDAO;
    IStudentRepository studentRepository;
    IStudentService studentService;

    @BeforeEach
    void setupData() {
        studentDAO = mock(StudentDAO.class);
        studentRepository = mock(StudentRepository.class);
        studentService = new StudentService(studentDAO, studentRepository);
    }

    @Test
    void testCreate() {
        // arrange
        List<SubjectDTO> subjects = new ArrayList<>();
        StudentDTO studentDTO = new StudentDTO(
                1L,
                "Roberto",
                "N/A",
                5.0,
                subjects);
        doNothing().when(studentDAO).save(studentDTO);
        // act
        studentService.create(studentDTO);
        // assert
        verify(studentDAO, times(1)).save(studentDTO);

    }

    @Test
    void testDeleteWhenEntityExist() {
        // arrange
        when(studentDAO.delete(anyLong())).thenReturn(true);
        // act
        Executable executionResult = () -> studentService.delete(anyLong());
        // assert
        assertDoesNotThrow(executionResult);
        verify(studentDAO, times(1)).delete(anyLong());
    }

    @Test
    void testDeleteWhenEntityNotExist() {
        // arrange

        doThrow(StudentNotFoundException.class).when(studentDAO).delete(anyLong());
        // act
        Executable executionResult = () -> studentService.delete(anyLong());
        // assert
        assertThrows(StudentNotFoundException.class, executionResult);
        verify(studentDAO, times(1)).delete(anyLong());
    }

    @Test
    void testGetAllWhenIsNotEmpty() {
        // arrange
        List<SubjectDTO> subjects = new ArrayList<>();
        StudentDTO studentDTO = new StudentDTO(
                1L,
                "Roberto",
                "N/A",
                5.0,
                subjects);
        HashSet<StudentDTO> studentsDTOlistToTest = new HashSet<>(Arrays.asList(studentDTO));
        when(studentRepository.findAll()).thenReturn(studentsDTOlistToTest);
        Integer listSizeExpected = studentsDTOlistToTest.size();
        // act
        Integer studentListSizeResult = studentService.getAll().size();
        // assert
        assertEquals(listSizeExpected, studentListSizeResult);
        verify(studentRepository, times(1)).findAll();
    }

    @Test
    void testGetAllWhenIsEmpty() {
        // arrange
        when(studentRepository.findAll()).thenReturn(new HashSet<>(Arrays.asList()));
        Integer listSizeExpected = 0;
        // act
        Integer studentListSizeResult = studentService.getAll().size();
        // assert
        assertEquals(listSizeExpected, studentListSizeResult);
        verify(studentRepository, times(1)).findAll();
    }

    @Test
    void testReadWithEntityExist() {
        // arrange
        List<SubjectDTO> subjects = new ArrayList<>();
        StudentDTO studentDTO = new StudentDTO(
                1L,
                "Roberto",
                "N/A",
                5.0,
                subjects);
        when(studentDAO.findById(studentDTO.getId())).thenReturn(studentDTO);
        // act
        StudentDTO studentDTOResult = studentService.read(studentDTO.getId());
        // assert
        assertEquals(studentDTO, studentDTOResult);
        verify(studentDAO, times(1)).findById(studentDTO.getId());
    }

    @Test
    void testReadWithEntityNotExist() {
        // arrange
        when(studentDAO.findById(anyLong())).thenThrow(StudentNotFoundException.class);
        // act
        Executable executionResult = () -> studentService.read(anyLong());
        // assert
        assertThrows(StudentNotFoundException.class, executionResult);
        verify(studentDAO, times(1)).findById(anyLong());
    }

    @Test
    void testUpdate() {
        // arrange
        List<SubjectDTO> subjects = new ArrayList<>();
        StudentDTO studentDTO = new StudentDTO(
                1L,
                "Roberto",
                "N/A",
                5.0,
                subjects);
        doNothing().when(studentDAO).save(studentDTO);
        // act
        studentService.update(studentDTO);
        // assert
        verify(studentDAO, times(1)).save(studentDTO);
    }
}
