package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class StudentRepositoryTest {

    IStudentRepository studentRepo;
    IStudentDAO studentDAO;
    @BeforeEach
    @AfterEach
    public void setUp() {
        //TestUtilsGenerator.emptyUsersFile();

        this.studentDAO = new StudentDAO();
        this.studentRepo = new StudentRepository();
    }

    @Test
    void findAll() {

        //ACT
        Set<StudentDTO> studentDTOSet = studentRepo.findAll();

        //ASSERT
        assertNotNull(studentDTOSet);

    }
}