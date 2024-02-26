package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class StudentDaoTest {



    @Autowired
    StudentDAO studentDAO;


    @Test
    public void saveTestOk(){
        StudentDTO studentDTO = new StudentDTO();
        List<SubjectDTO> subjectDTOS = new ArrayList<>();

        subjectDTOS.add(new SubjectDTO("matematicas",5.0));
        subjectDTOS.add(new SubjectDTO("español",8.0));
        subjectDTOS.add(new SubjectDTO("ingles",9.0));

        studentDTO.setStudentName("");
        studentDTO.setSubjects(subjectDTOS);
        studentDTO.setId(3L);


        studentDAO.save(studentDTO);

        StudentDTO student = studentDAO.findById(3L);

        assertTrue(student != null);

    }

    @Test
    public void findByIdTestOk(){


        StudentDTO student = studentDAO.findById(1L);

        assertTrue(student != null);

    }

    @Test
    public void findByIdTestNoOk(){

        //StudentDTO student = studentDAO.findById(100L);

        assertThrows(StudentNotFoundException.class,() ->studentDAO.findById(100L));


    }


    @Test
    public void deleteOk(){

       boolean studentDeleteResult = studentDAO.delete(3L);

        assertTrue(studentDeleteResult);

    }


    @Test
    public void deleteNoOk(){

        boolean studentDeleteResult = studentDAO.delete(30000L);

        assertFalse(studentDeleteResult);

    }





}
