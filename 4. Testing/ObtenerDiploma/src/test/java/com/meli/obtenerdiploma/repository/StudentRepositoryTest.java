package com.meli.obtenerdiploma.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;


import static org.mockito.ArgumentMatchers.anyString;
@ExtendWith(MockitoExtension.class)
class StudentRepositoryTest {
    StudentRepository studentRepository = new StudentRepository();

    @Test
    void findAll() {
        Assertions.assertNotNull(studentRepository.findAll());
    }
}