package com.meli.obtenerdiploma.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

@ExtendWith(MockitoExtension.class)
public class StudentRepositoryTest {
    @Autowired
    StudentRepository studentRepository;

    @Test
    void findAll(){

    }

}
