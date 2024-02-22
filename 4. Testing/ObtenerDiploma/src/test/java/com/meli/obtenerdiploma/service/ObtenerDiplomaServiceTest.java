package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.jupiter.api.Assertions.*;

class ObtenerDiplomaServiceTest {
    @Test
    void analyzeScoresWhenStudentPass() {
        //Arrange
        ObtenerDiplomaService service = new ObtenerDiplomaService();
        SubjectDTO testSubject1 = new SubjectDTO();
        testSubject1.setName("Mates");
        testSubject1.setScore(9.0);
        SubjectDTO testSubject2 = new SubjectDTO();
        testSubject2.setName("Ingles");
        testSubject2.setScore(10.0);
        List<SubjectDTO> testSubjects = new ArrayList<>(List.of(testSubject1, testSubject2));
        StudentDTO testStudent = new StudentDTO();
        testStudent.setStudentName("Testeado");
        testStudent.setSubjects(testSubjects);

        StudentDTO expectedStudent = new StudentDTO();
        expectedStudent.setStudentName("Testeado");
        expectedStudent.setSubjects(testSubjects);
        expectedStudent.setAverageScore(9.5);
        expectedStudent.setMessage("El alumno Testeado ha obtenido un promedio de 9,5. Felicitaciones!");

        //Act
        StudentDTO result = service.analyzeScores(testStudent);

        //Arrange
        MatcherAssert.assertThat(result, samePropertyValuesAs(expectedStudent));
    }
    @Test
    void analyzeScoresWhenStudentDoesntPass() {
        //Arrange
        ObtenerDiplomaService service = new ObtenerDiplomaService();
        SubjectDTO testSubject1 = new SubjectDTO();
        testSubject1.setName("Mates");
        testSubject1.setScore(9.0);
        SubjectDTO testSubject2 = new SubjectDTO();
        testSubject2.setName("Ingles");
        testSubject2.setScore(8.0);
        List<SubjectDTO> testSubjects = new ArrayList<>(List.of(testSubject1, testSubject2));
        StudentDTO testStudent = new StudentDTO();
        testStudent.setStudentName("Testeado");
        testStudent.setSubjects(testSubjects);

        StudentDTO expectedStudent = new StudentDTO();
        expectedStudent.setStudentName("Testeado");
        expectedStudent.setSubjects(testSubjects);
        expectedStudent.setAverageScore(8.5);
        expectedStudent.setMessage("El alumno Testeado ha obtenido un promedio de 8,5. Puedes mejorar.");

        //Act
        StudentDTO result = service.analyzeScores(testStudent);

        //Arrange
        MatcherAssert.assertThat(result, samePropertyValuesAs(expectedStudent));
    }
}