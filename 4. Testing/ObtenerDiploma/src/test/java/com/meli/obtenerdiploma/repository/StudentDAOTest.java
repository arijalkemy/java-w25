package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class StudentDAOTest {
    StudentDAO studentDAO = new StudentDAO();

    @Test
    void saveOK() {
        StudentDTO studentDTOMock = getStudentWith3Subjects("Juan Manuel");

        studentDAO.save(studentDTOMock);

        Assertions.assertTrue(studentDAO.exists(studentDTOMock));
    }
    @Test
    void deleteOK(){
        StudentDTO studentDTOMock = getStudentWith3Subjects("Juan Manuel");

        studentDAO.delete(9999L);

        Assertions.assertFalse(studentDAO.exists(studentDTOMock));
    }
    @Test
    void existsOK(){
        StudentDTO studentDTOMock = getStudentWith3Subjects("Juan Manuel");
        studentDAO.save(studentDTOMock);
        boolean response = studentDAO.exists(studentDTOMock);

        Assertions.assertTrue(response);
    }
    @Test
    void findByIdOK(){
        StudentDTO studentDTOExpected = getStudentWith3Subjects("Juan Manuel");

        StudentDTO studentDTOObtained = studentDAO.findById(9999L);

        assertThat(studentDTOObtained).usingRecursiveComparison().isEqualTo(studentDTOExpected);

    }
    @Test
    void findByIdNonExistsStudent(){
        studentDAO.delete(9999L);

        Assertions.assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(9999L));
    }
    private StudentDTO getStudentWith3Subjects(String name) {
        SubjectDTO subject1 = new SubjectDTO("Matemática", 8.0);
        SubjectDTO subject2 = new SubjectDTO("Lengua", 6.0);
        SubjectDTO subject3 = new SubjectDTO("Física", 4.0);

        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(subject1);
        subjects.add(subject2);
        subjects.add(subject3);

        StudentDTO stu = new StudentDTO();
        stu.setId(9999L);
        stu.setStudentName(name);
        stu.setSubjects(subjects);

        return stu;
    }
    private Set<StudentDTO> getStudentSet() {
        StudentDTO stu1 = getStudentWith3Subjects("Marco");
        StudentDTO stu2 = getStudentWith3Subjects("Marco Polo");
        StudentDTO stu3 = getStudentWith3Subjects("Julio");
        StudentDTO stu4 = getStudentWith3Subjects("Julio Cesar");

        return new HashSet<StudentDTO>(){{add(stu1); add(stu2); add(stu3); add(stu4);}};
    }
}
