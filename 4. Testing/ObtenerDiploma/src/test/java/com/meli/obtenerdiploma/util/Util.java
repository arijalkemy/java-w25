package com.meli.obtenerdiploma.util;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Util {
    public static StudentDTO getStudenDtoComplete(){
        String studentName = "Emma";
        Double average = 8.0;

        return new StudentDTO(
                1L,
                studentName,
                "El alumno " + studentName + " ha obtenido un promedio de " + new DecimalFormat("#.##").format(average)
                + ((average > 9) ? ". Felicitaciones!" : ". Puedes mejorar."),
                average,
                new ArrayList<SubjectDTO>(
                        List.of(
                                new SubjectDTO("Calculo",average),
                                new SubjectDTO("Deportes", average)
                        )
                ));
    }
    public static StudentDTO getStudenDto(){
        double average = 8.0;
        return new StudentDTO(
                3L,
                "Mario",null,null,
                new ArrayList<SubjectDTO>(
                        List.of(
                                new SubjectDTO("Calculo",average),
                                new SubjectDTO("Deportes", average)
                        )
                ));
    }
    public static HashSet<StudentDTO> getAllStudenDto(){

        return new HashSet<StudentDTO>(List.of(
                new StudentDTO(
                        1L,
                        "Juan",null,null,
                        new ArrayList<SubjectDTO>(
                                List.of(
                                        new SubjectDTO("Matemática",9.0),
                                        new SubjectDTO("Física", 7.0),
                                        new SubjectDTO("Química", 6.0)
                                )
                        )),
                new StudentDTO(
                        2L,
                        "Pedro",null,null,
                        new ArrayList<SubjectDTO>(
                                List.of(
                                        new SubjectDTO("Matemática",10.0),
                                        new SubjectDTO("Física", 8.0),
                                        new SubjectDTO("Química", 4.0)
                                )
                        ))
        ));
    }
}
