package utils;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FactoryStudent {

    public Set<StudentDTO> getAllStudents(){

        StudentDTO s1 = new StudentDTO();
        s1.setId(1L);
        s1.setStudentName("Juan");

        SubjectDTO subject1 = new SubjectDTO("Física", 7D);
        SubjectDTO subject3 = new SubjectDTO("Química", 6D);
        SubjectDTO subject2 = new SubjectDTO("Matemática", 9D);
        s1.setSubjects(new ArrayList<SubjectDTO>(List.of(subject2, subject1, subject3)));

        StudentDTO s2 = new StudentDTO();
        s2.setId(2L);
        s2.setStudentName("Pedro");

        SubjectDTO subject4 = new SubjectDTO("Fisica", 8D);
        SubjectDTO subject5 = new SubjectDTO("Quimica", 4D);
        SubjectDTO subject6 = new SubjectDTO("Matemática", 10D);
        s2.setSubjects(new ArrayList<SubjectDTO>(List.of(subject6, subject4, subject5)));

        return new HashSet<>(Set.of(s1,s2));
    }

    public StudentDTO getStudent() {
        StudentDTO s = new StudentDTO();
        s.setId(2L);
        s.setStudentName("Pedro");

        SubjectDTO subject1 = new SubjectDTO("Física", 8D);
        SubjectDTO subject3 = new SubjectDTO("Química", 4D);
        SubjectDTO subject2 = new SubjectDTO("Matemática", 10D);
        s.setSubjects(new ArrayList<>(List.of(subject2, subject1, subject3)));

        return s;
    }

    public StudentDTO getNewStudent() {
        StudentDTO s = new StudentDTO();
        s.setId(3L);
        s.setStudentName("Andres");

        SubjectDTO subject1 = new SubjectDTO("Física", 10D);
        SubjectDTO subject3 = new SubjectDTO("Química", 7D);
        SubjectDTO subject2 = new SubjectDTO("Matemática", 9D);
        s.setSubjects(new ArrayList<>(List.of(subject2, subject1, subject3)));

        return s;
    }

    public StudentDTO getStudentObtenerDiplomaExpectedTest() {
        StudentDTO s = new StudentDTO();
        s.setId(2L);
        s.setStudentName("Pedro");

        SubjectDTO subject1 = new SubjectDTO("Fisica", 8D);
        SubjectDTO subject3 = new SubjectDTO("Quimica", 4D);
        SubjectDTO subject2 = new SubjectDTO("Matemáticas", 10D);
        s.setSubjects(new ArrayList<SubjectDTO>(List.of(subject2, subject3, subject1)));
        s.setAverageScore((8D + 4D + 10D)/3);
        s.setMessage("El alumno Pedro ha obtenido un promedio de 7.33. Puedes mejorar.");
        return s;
    }
}
