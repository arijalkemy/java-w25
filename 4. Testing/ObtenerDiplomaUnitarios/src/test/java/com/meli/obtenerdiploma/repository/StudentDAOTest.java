package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class StudentDAOTest {
    StudentDAO studentDAO = new StudentDAO();

    @Test
    void saveOK() {
        SubjectDTO subject1 = new SubjectDTO("Matemática", 7.0);
        SubjectDTO subject2 = new SubjectDTO("Ciencia", 8.0);
        SubjectDTO subject3 = new SubjectDTO("Artes", 9.0);

        List<SubjectDTO> listSubjects = new ArrayList<>();
        listSubjects.add(subject1);
        listSubjects.add(subject2);
        listSubjects.add(subject3);

        StudentDTO studentDTOExpected = new StudentDTO(5L,"John Doe","Pasó",8.8,listSubjects);

        studentDAO.save(studentDTOExpected);
        boolean response = studentDAO.exists(studentDTOExpected);

        Assertions.assertTrue(response);
    }
    @Test
    void deleteOK(){
        SubjectDTO subject1 = new SubjectDTO("Matemática", 7.0);
        SubjectDTO subject2 = new SubjectDTO("Ciencia", 8.0);
        SubjectDTO subject3 = new SubjectDTO("Artes", 9.0);

        List<SubjectDTO> listSubjects = new ArrayList<>();
        listSubjects.add(subject1);
        listSubjects.add(subject2);
        listSubjects.add(subject3);

        StudentDTO studentDTOExpected = new StudentDTO(5L,"John Doe","Pasó",8.8,listSubjects);

        studentDAO.delete(5L);
        boolean response = studentDAO.exists(studentDTOExpected);

        Assertions.assertFalse(response);
    }
    @Test
    void existsOK(){
        SubjectDTO subject1 = new SubjectDTO("Matemática", 7.0);
        SubjectDTO subject2 = new SubjectDTO("Ciencia", 8.0);
        SubjectDTO subject3 = new SubjectDTO("Artes", 9.0);

        List<SubjectDTO> listSubjects = new ArrayList<>();
        listSubjects.add(subject1);
        listSubjects.add(subject2);
        listSubjects.add(subject3);

        StudentDTO studentDTOExpected = new StudentDTO(5L,"John Doe","Pasó",8.8,listSubjects);

        studentDAO.save(studentDTOExpected);
        boolean response = studentDAO.exists(studentDTOExpected);

        Assertions.assertTrue(response);
    }
    @Test
    void findByIdOK(){
        SubjectDTO subject1 = new SubjectDTO("Matemática", 7.0);
        SubjectDTO subject2 = new SubjectDTO("Ciencia", 8.0);
        SubjectDTO subject3 = new SubjectDTO("Artes", 9.0);

        List<SubjectDTO> listSubjects = new ArrayList<>();
        listSubjects.add(subject1);
        listSubjects.add(subject2);
        listSubjects.add(subject3);

        StudentDTO studentDTOExpected = new StudentDTO(5L,"John Doe","Pasó",8.8,listSubjects);

        StudentDTO studentDTOActual = studentDAO.findById(5L);
        assertThat(studentDTOActual).usingRecursiveComparison().isEqualTo(studentDTOExpected);
    }
    @Test
    void findByIdNonExistsStudent(){
        studentDAO.delete(1L);
        Assertions.assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(1L));
    }
}