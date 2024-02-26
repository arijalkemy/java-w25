package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class StudentRepositoryTest {

    IStudentRepository studentRepository;
    @BeforeEach
    public void setUp(){
        TestUtilsGenerator.loadUserFile();
        studentRepository = new StudentRepository();
    }
    @Test
    void findAll() {
        //arrange
        Set<StudentDTO> expectedStudents = Set.of(TestUtilsGenerator.getExampleStudent());
        //act
        Set<StudentDTO> actualStudents = studentRepository.findAll();
        //assert
        assertTrue(CollectionUtils.isEqualCollection(expectedStudents, actualStudents));
    }

    @Test
    void findAllFileNotFound() throws IOException {
        //arrange
        TestUtilsGenerator.erraseFile();
        //act and assert
        assertTrue(CollectionUtils.isEqualCollection(Set.of(), studentRepository.findAll()));
        TestUtilsGenerator.createFile();
    }

}