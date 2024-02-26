package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class StudentServiceTest {
    @Mock
    IStudentDAO studentDAO;
    @Mock
    IStudentRepository studentRepository;
    @InjectMocks
    StudentService studentService;
    @Test
    void create() {
        //Debido a que el metodo no devuelve ningun valor se tendria que validarque elmetodo se llama al menos una vez
        //Por que si se llama menos o mas veces el test falla indicando que el metodo esta fallando también.

        //arrange
        StudentDTO expectedStudentDTO=loadStudent();
        studentService.create(expectedStudentDTO);
        //act & assert
        verify(studentDAO, atLeast(1)).save(expectedStudentDTO);
    }

    @Test
    void read() {
        //arrange
        StudentDTO expectedStudent = loadStudent();
        long id = 3L;

        //act
        Mockito.when(studentDAO.findById(3L)).thenReturn(loadStudent());
        StudentDTO actual = studentService.read(3L);

        //assert
        assertEquals(expectedStudent, actual);
    }

    @Test
    void update() {
        studentService.create(loadStudent());
        System.out.println(studentDAO.findById(Long.valueOf(1)));

    }

    @Test
    void delete() {
    //arrange
    studentService.delete(1L);

    //studentDAO.delete(1L);

    //act & assert
    Mockito.verify(studentDAO, atLeast(1)).delete(1L);

    //Mockito.verify(studentDAO, Mockito.times(1)).save();

    }

    @Test
    void getAll() {
        //StudentDTO studen = loadStudent();
      // arrange
      studentService.getAll();
      //act & assert
      Mockito.verify(studentRepository,atLeast(1)).findAll();

       //Mockito.when(studentRepository.findAll()).thenReturn(student);
    //assertEquals(student, studen);

    }


    private StudentDTO loadStudent(){
        return new StudentDTO(
                3L,
                "jorge",
                "El alumno jorge ha obtenido un promedio de 9.5. Felicitaciones!",
                9.5,
                List.of(
                        new SubjectDTO(
                                "subject11",
                                9.5
                        )
                )
        );
    }
}