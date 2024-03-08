package com.meli.obtenerdiploma.utils;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestData {

    public static StudentDTO getStudent(String name){
        List<SubjectDTO> subjects = Arrays.asList(
                new SubjectDTO("Math", 8.0),
                new SubjectDTO("History", 7.0),
                new SubjectDTO("Science", 9.0)
        );
        StudentDTO student = new StudentDTO(1L,
                name,
                "",
                0.0,
                subjects);

        return student;
    }

    public static Set<StudentDTO> getStudentSet(){
        Set<StudentDTO> studentDTOSet = new HashSet<>();
        studentDTOSet.add(getStudent("Pablito Perez"));
        studentDTOSet.add(getStudent("Samaneh Diaz"));
        studentDTOSet.add(getStudent("Juanito Suarez"));

        return studentDTOSet;
    }
}
