package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

public class StudentDAOTest {

    StudentDAO studentDAO;

    @BeforeEach
    public void before(){
        studentDAO = new StudentDAO();
    }

    @Test
    public void shouldSaveStudentOk(){

    }
}
