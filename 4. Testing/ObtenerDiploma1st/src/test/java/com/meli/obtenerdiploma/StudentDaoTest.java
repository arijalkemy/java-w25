package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class StudentDaoTest {

    StudentDTO studentExpected = new StudentDTO(16L,"Pedro",null,null, List.of(
            new SubjectDTO("Matemática",10.0),
            new SubjectDTO("Física",  7.0),
            new SubjectDTO("Química",  6.0)
    ));
    @Test
    void studentDaoTest(){
        //ARRANGE
            StudentDAO studentDAO = new StudentDAO();
            //(using studentExpected)
        //ACT
        studentDAO.save(studentExpected);
        StudentDTO studentCreated = studentDAO.findById(16L);
        //ASSERT
        assertEquals(16L,studentCreated.getId());
    }
}
