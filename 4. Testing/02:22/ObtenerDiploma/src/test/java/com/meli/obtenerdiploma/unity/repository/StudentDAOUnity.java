package com.meli.obtenerdiploma.unity.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;

@SpringBootTest
public class StudentDAOUnity {

    static StudentDAO studentDAO = new StudentDAO();

    // ----------------------------------------------------- save
    // -----------------------------------------------------
    @Test
    public void saveOkTest() {
        // Arrange:
        StudentDTO param = new StudentDTO(1L, "Messi", "Sin mensaje", 6.0, List.of(new SubjectDTO("Matematica", 6.0)));
        // Act:
        studentDAO.save(param);
        // Assert:
        Assertions.assertTrue(studentDAO.exists(param));
        Assertions.assertEquals(studentDAO.findById(param.getId()), param);
    }

    // ----------------------------------------------------- delete
    // -----------------------------------------------------
    @Test
    public void deleteOkTest() {
        // Arrange:
        StudentDTO param = new StudentDTO(1L, "Messi", "Sin mensaje", 6.0, List.of(new SubjectDTO("Matematica", 6.0)));
        studentDAO.save(param);
        // Act:
        studentDAO.delete(param.getId());
        // Assert:
        Assertions.assertFalse(studentDAO.exists(param));
    }

    // ----------------------------------------------------- exists
    // -----------------------------------------------------
    @Test
    public void existsOkTest() {
        // Arrange:
        StudentDTO param = new StudentDTO(1L, "Messi", "Sin mensaje", 6.0, List.of(new SubjectDTO("Matematica", 6.0)));
        studentDAO.save(param);
        // Act:
        Boolean result = studentDAO.exists(param);
        // Assert:
        assertEquals(true, result);
    }

    @Test
    public void existsNotOkTest() {
        // Arrange:
        StudentDTO param = new StudentDTO(999L, "Messi", "Sin mensaje", 6.0,
                List.of(new SubjectDTO("Matematica", 6.0)));
        // Act:
        Boolean result = studentDAO.exists(param);
        // Assert:
        assertEquals(false, result);
    }

    // ----------------------------------------------------- findById
    // -----------------------------------------------------
    @Test
    public void findByIdOkTest() {
        // Arrange:
        StudentDTO param = new StudentDTO(1L, "Messi", "Sin mensaje", 6.0, List.of(new SubjectDTO("Matematica", 6.0)));
        studentDAO.save(param);
        // Act:
        StudentDTO result = studentDAO.findById(param.getId());
        // Assert:
        assertEquals(param, result);
    }

    @Test
    public void findByIdNotOkTest() {
        // Arrange:
        StudentDTO param = new StudentDTO(999L, "Messi", "Sin mensaje", 6.0,
                List.of(new SubjectDTO("Matematica", 6.0)));
        // Act:
        StudentDTO result = studentDAO.findById(param.getId());
        // Assert:
        assertEquals(null, result);
    }

}
