package com.meli.obtenerdiploma.util;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ObjectFactory {
    public static StudentDTO createMockStudent(Long studentId) {
        return new StudentDTO(
                studentId,
                "Juan",
                null,
                null,
                createListSubjectDTO());
    }

    public static StudentDTO createExpectedStudent(Long studentId) {
        return new StudentDTO(
                studentId,
                "Juan",
                mensajeString("Juan"),
                (9.0+7.0+6.0)/3,
                createListSubjectDTO());
    }

    public static Set<StudentDTO> createListStudentDTO() {
        Set<StudentDTO> res = new HashSet<>();
        res.add(new StudentDTO(1L,"Juan",null,null, createListSubjectDTO()));
        res.add(new StudentDTO(2L,"Pedro",null,null, createListSubjectDTO()));
        return res;
    }

    private static List<SubjectDTO> createListSubjectDTO(){
        return List.of(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0)
                );
    }

    private static String mensajeString(String name){
        return "El alumno " + name + " ha obtenido un promedio de 7.33. Puedes mejorar.";
    }
}
