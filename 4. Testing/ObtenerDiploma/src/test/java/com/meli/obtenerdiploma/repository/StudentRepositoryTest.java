package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.Util;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;
    @Test
    void findAll() {
        //Arrange
        Set<StudentDTO> studentDTOSetExpected = Util.getAllStudenDto();
        Set<StudentDTO> studentDTOSetResult;

        //Act
        studentDTOSetResult = studentRepository.findAll();

        //Assert
        assertEquals(studentDTOSetExpected,studentDTOSetResult);

    }
}