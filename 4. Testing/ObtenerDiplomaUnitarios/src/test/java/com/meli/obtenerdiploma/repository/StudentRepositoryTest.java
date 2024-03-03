package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class StudentRepositoryTest {
    @Autowired
    StudentRepository studentRepository;

    @Test
    void findAllOK(){
        SubjectDTO subject1 = new SubjectDTO("Matemática", 7.0);
        SubjectDTO subject2 = new SubjectDTO("Ciencia", 8.0);
        SubjectDTO subject3 = new SubjectDTO("Artes", 9.0);

        List<SubjectDTO> listSubjects = new ArrayList<>();
        listSubjects.add(subject1);
        listSubjects.add(subject2);
        listSubjects.add(subject3);

        StudentDTO studentDTO1 = new StudentDTO(5L,"John Doe","Pasó",8.8,listSubjects);
        StudentDTO studentDTO2 = new StudentDTO(6L,"Marie Cure","Pasó",7.8,listSubjects);
        StudentDTO studentDTO3 = new StudentDTO(7L,"Saray Cull","Pasó",9.8,listSubjects);
        HashSet<StudentDTO> studentSetExpected = new HashSet<>();
        studentSetExpected.add(studentDTO1);
        studentSetExpected.add(studentDTO2);
        studentSetExpected.add(studentDTO3);

        Set<StudentDTO> studentSetActual = studentRepository.findAll();

        assertThat(studentSetActual).usingRecursiveComparison().isEqualTo(studentSetExpected);
    }
}
