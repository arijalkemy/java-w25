package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class StudentRepositoryTest {

    @Autowired
    IStudentRepository studentRepository;


    @Test
    public void findAllOk(){

        Set<StudentDTO> studentDTOSet = studentRepository.findAll();

        assertTrue(studentDTOSet.size() > 0);


    }

}
