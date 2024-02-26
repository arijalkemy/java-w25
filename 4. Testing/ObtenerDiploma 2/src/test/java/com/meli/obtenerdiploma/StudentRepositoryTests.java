package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import utils.FactoryStudent;

import java.util.List;
import java.util.Set;

@SpringBootTest
public class StudentRepositoryTests {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentDAO studentDAO;

    FactoryStudent f = new FactoryStudent();

    @Test
    void findByIdTestOk() {
        // Arrange
        Long param = 1L;
        StudentDTO expected = f.getJuanStudent();
        // Act y assert
        Assertions.assertEquals(expected, studentDAO.findById(param));
    }

    @Test
    void deleteTestOkFalse(){
        // Arrange
        Long param = 3L; // no existe
        boolean expected = false;
        // Act y assert
        Assertions.assertEquals(expected, studentDAO.delete(param));
    }

    @Test
    void deleteTestOkTrue(){
        // Arrange
        Long param = 2L; // existe
        boolean expected = true;
        // Act y assert
        Assertions.assertEquals(expected, studentDAO.delete(param));
    }

    @Test
    void findAllTestOk(){
        Set<StudentDTO> expected = f.getAllStudents();
        // Act y assert
        Assertions.assertEquals(expected, studentRepository.findAll());
    }


}
