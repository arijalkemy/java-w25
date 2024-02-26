package com.meli.obtenerdiploma.service.factory;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;

import java.util.List;
import java.util.Set;

public class TestFactory {

    public static StudentDTO createStudentDTO(){
        return new StudentDTO(1L,"Julio","",0.0,
                List.of(new SubjectDTO("Matematicas",12.3),
                        new SubjectDTO("Español",7.7)));
    }

    public static Set<StudentDTO> createListStudentDto(){
        return Set.of(
                new StudentDTO(1L, "Mario","",0.0,createListSubjectsDto()),
                new StudentDTO(2L, "Maria","",0.0,createListSubjectsDto()),
                new StudentDTO(3L, "Julio","",0.0,createListSubjectsDto())
        );
    }

    public static List<SubjectDTO> createListSubjectsDto(){
        return List.of(
                new SubjectDTO("Matematicas", 5.0),
                new SubjectDTO("Ingles", 7.9 ),
                new SubjectDTO("Español",9.8)
        );
    }


}
