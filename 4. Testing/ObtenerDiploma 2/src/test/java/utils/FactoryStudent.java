package utils;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FactoryStudent {

    public StudentDTO getPedroStudent() {
        StudentDTO s = new StudentDTO();
        s.setId(2L);
        s.setStudentName("Pedro");

        SubjectDTO subject1 = new SubjectDTO("Fisica", 8D);
        SubjectDTO subject3 = new SubjectDTO("Quimica", 4D);
        SubjectDTO subject2 = new SubjectDTO("Matematica", 10D);
        s.setSubjects(new ArrayList<SubjectDTO>(List.of(subject2, subject1, subject3)));

        return s;
    }

    public StudentDTO getJuanStudent() {
        StudentDTO s = new StudentDTO();
        s.setId(1L);
        s.setStudentName("Juan");

        SubjectDTO subject1 = new SubjectDTO("Fisica", 7D);
        SubjectDTO subject3 = new SubjectDTO("Quimica", 6D);
        SubjectDTO subject2 = new SubjectDTO("Matematica", 9D);
        s.setSubjects(new ArrayList<SubjectDTO>(List.of(subject2, subject1, subject3)));

        return s;
    }

    public StudentDTO getStudentObtenerDiplomaExpectedTest() {
        StudentDTO s = new StudentDTO();
        s.setId(2L);
        s.setStudentName("Pedro");

        SubjectDTO subject1 = new SubjectDTO("Fisica", 8D);
        SubjectDTO subject3 = new SubjectDTO("Quimica", 4D);
        SubjectDTO subject2 = new SubjectDTO("Matematica", 10D);
        s.setSubjects(new ArrayList<SubjectDTO>(List.of(subject2, subject1, subject3)));
        s.setAverageScore((8D + 4D + 10D)/3);
        s.setMessage("El alumno Pedro ha obtenido un promedio de 7.33. Puedes mejorar.");
        return s;
    }

    public Set<StudentDTO> getAllStudents() {
        return Set.of(this.getJuanStudent(), this.getPedroStudent());
    }
}
