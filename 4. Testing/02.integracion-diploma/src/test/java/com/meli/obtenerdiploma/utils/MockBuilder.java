package com.meli.obtenerdiploma.utils;

import com.meli.obtenerdiploma.model.ErrorDTO;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.springframework.http.HttpStatus;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MockBuilder {
    public static StudentDTO buildParamStudent(Long studentId) {
        return new StudentDTO(
                studentId,
                "Juan",
                null,
                null,
                buildSubjectDTOList());
    }

    public static StudentDTO buildModifyParamStudent(Long studentId) {
        return new StudentDTO(
                studentId,
                "Juancito",
                null,
                null,
                buildSubjectDTOList());
    }

    public static StudentDTO buildExpectedStudent(Long studentId) {
        return new StudentDTO(
                studentId,
                "Juan",
                buildExpectedMessage("Juan"),
                7.33,
                buildSubjectDTOList());
    }

    public static Set<StudentDTO> buildStudentDTOSet() {
        Set<StudentDTO> res = new HashSet<>();
        res.add(new StudentDTO(1L, "Juan", null, null, buildSubjectDTOList()));
        res.add(new StudentDTO(2L, "Pedro", null, null, buildSubjectDTO2List()));
        return res;
    }

    private static String buildExpectedMessage(String name) {
        return "El alumno " + name + " ha obtenido un promedio de 7.33. Puedes mejorar.";
    }

    private static List<SubjectDTO> buildSubjectDTOList() {
        return List.of(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0)
        );
    }

    private static List<SubjectDTO> buildSubjectDTO2List() {
        return List.of(
                new SubjectDTO("Matemática", 10.0),
                new SubjectDTO("Física", 8.0),
                new SubjectDTO("Química", 4.0)
        );
    }

    private static ErrorDTO buildObtenerDiplomaExceptionMessage(Long id) {
        return new ErrorDTO(
                "StudentNotFoundException",
                "El estudiante con el Id " + id + " no ha sido encontrado."
        );
    }
}
