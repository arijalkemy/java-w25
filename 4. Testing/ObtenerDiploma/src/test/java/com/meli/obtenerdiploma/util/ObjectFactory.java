package com.meli.obtenerdiploma.util;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;

import java.util.List;
import java.util.Set;

public class ObjectFactory {
    public static StudentDTO createStudentDTOWithAverageBelowNine() {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(0L);
        studentDTO.setStudentName("Juan Pérez");
        studentDTO.setSubjects(List.of(
                new SubjectDTO("Matemáticas", 5.0),
                new SubjectDTO("Física", 8.0),
                new SubjectDTO("Química", 7.0)
        ));
        return studentDTO;
    }

    public static StudentDTO createStudentDTOWithAverageAboveNine() {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(99L);
        studentDTO.setStudentName("Juan Pérez");
        studentDTO.setSubjects(List.of(
                new SubjectDTO("Matemáticas", 10.0),
                new SubjectDTO("Física", 9.0),
                new SubjectDTO("Química", 9.0)
        ));
        return studentDTO;
    }

    public static Set<StudentDTO> createSetStudentDTO() {
        return Set.of(
                createStudentDTOWithAverageBelowNine(),
                createStudentDTOWithAverageAboveNine()
        );
    }
}
