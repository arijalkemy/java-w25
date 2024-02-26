package com.meli.obtenerdiploma.controllers;

import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.xml.sax.SAXException;

import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.xml.bind.ValidationException;
import javax.xml.validation.Validator;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class StudentControllerTests {
    @Mock
    IStudentService service;

    @InjectMocks
    StudentController controller;





    @Test
    void createInvalidStudent() throws IOException, SAXException {
        //ARRANGE
        Long id = 1002L;
        when(service.read(id)).thenThrow(new StudentNotFoundException(id));

        // ACT & ASSERT
        assertThrows(StudentNotFoundException.class, () -> {
            controller.getStudent(id);
        });
    }


}
