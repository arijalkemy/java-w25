package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentDAOTests {
    private StudentDAO studentDAO;

    @BeforeEach
    private void setup() {
        studentDAO = new StudentDAO();
    }

    private StudentDTO getStudentDTO() {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("Test");
        studentDTO.setSubjects(List.of(new SubjectDTO[]{
                new SubjectDTO("Test", 10.0),
                new SubjectDTO("Test", 10.0),
                new SubjectDTO("Test", 10.0),
                new SubjectDTO("Test", 10.0),
                new SubjectDTO("Test", 10.0)
        }));
        return studentDTO;
    }

    @Test
    public void testSave() {
        //Arrange
        StudentDTO studentDTO = getStudentDTO();
        //Act
        studentDAO.save(studentDTO);
        //Assert
        verify(studentDAO, atLeast(1)).save(studentDTO);
    }
}
