package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class StudentDAOTest {
    StudentDAO studentDAO = new StudentDAO();

    @Test
    public void saveOk(){
        StudentDTO student = new StudentDTO(1L, "Juan", "message", 0D,
                List.of());

        studentDAO.save(student);

        assertTrue(studentDAO.exists(student));
    }

    @Test
    public void deleteOk(){
        Long id = 1L;
        StudentDTO student = new StudentDTO(1L, "Juan", "message", 0D,
                List.of());

        studentDAO.save(student);
        studentDAO.delete(id);
        assertFalse(studentDAO.exists(student));
    }

    @Test
    public void existsOk(){
        StudentDTO student = new StudentDTO(1L, "Juan", "message", 0D,
                List.of());
        studentDAO.save(student);
        boolean response = studentDAO.exists(student);
        assertTrue(response);
    }

    @Test
    public void findByIdOk(){
        Long id = 2L;
        StudentDTO expected = new StudentDTO(2L, "Juan", "message", 0D,
                List.of());
        studentDAO.save(expected);
        System.out.println(studentDAO.findById(id));

        assertThat(expected).isEqualTo(studentDAO.findById(id));
    }
}
