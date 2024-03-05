package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.utils.TestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.text.Utilities;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentDAO studentDAO;

    @BeforeEach
    public void setUp(){
        TestUtils.emptyUsersFile();
        studentDAO.cleanUp();
        studentDAO.save(TestUtils.generateStudent1());
        studentDAO.save(TestUtils.generateStudent2());
    }

    @Test
    void findAll() {
        //Arrange
        Set<StudentDTO> expectedSet = TestUtils.getAllStudents();
        //Act
        Set<StudentDTO> set = studentRepository.findAll();
        //Assert
        System.out.println(set);
        assertThat(expectedSet).usingRecursiveComparison().isEqualTo(set);
    }
}