package com.meli.obtenerdiploma.utils;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;

import java.util.List;
import java.util.Set;

public class TestUtilGenerator {
    public static StudentDTO generateStudentDTOWith3Subj() {
        return new StudentDTO(1L, "TestStudent", "Test", 8D, generateListOf3Subj());
    }

    public static Set<StudentDTO> generateSetWith3StudentDTO() {
        StudentDTO studentA = new StudentDTO(1L, "TestStudentA", "Test", 8D, generateListOf3Subj());
        StudentDTO studentB = new StudentDTO(2L, "TestStudentB", "Test", 8D, generateListOf3Subj());
        StudentDTO studentC = new StudentDTO(3L, "TestStudentC", "Test", 8D, generateListOf3Subj());

        return Set.of(studentA, studentB, studentC);
    }

    public static List<SubjectDTO> generateListOf3Subj() {
        SubjectDTO math = new SubjectDTO("Math", 9.0);
        SubjectDTO art = new SubjectDTO("Art", 8.0);
        SubjectDTO history = new SubjectDTO("History", 7.0);

        return List.of(math, art, history);
    }
}
