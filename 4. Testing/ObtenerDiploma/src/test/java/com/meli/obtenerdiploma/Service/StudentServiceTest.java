package com.meli.obtenerdiploma.Service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private IStudentDAO studentDAO;
    @Mock
    private IStudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;


    @Test
    public void createTestOk(){
        //Arrange
        StudentDTO studentExpected = new StudentDTO(1L,"Carlos","Melo",5.5,new ArrayList<>());
        //Act
        studentService.create(studentExpected);
        //Assert
        verify(studentDAO,times(1)).save(studentExpected);

    }
    @Test
    public void readTestOk(){
        Long id = 5L;
        //Act
        studentService.read(id);
        //Assert
        verify(studentDAO,times(1)).findById(id);
    }
    @Test
    public void updateTestOk(){
        StudentDTO studentExpected = new StudentDTO(1L,"Carlos","Melo",5.5,new ArrayList<>());
        //Act
        studentService.update(studentExpected);
        //Assert
        verify(studentDAO,times(1)).save(studentExpected);
    }
    @Test
    public void deleteTestOk(){
        //Act
        studentService.delete(5L);
        //Assert
        verify(studentDAO,times(1)).delete(5L);
    }
    @Test
    public void getAllTestOk(){
        //Act
        studentService.getAll();
        //Assert
        verify(studentRepository,times(1)).findAll();

    }
}
