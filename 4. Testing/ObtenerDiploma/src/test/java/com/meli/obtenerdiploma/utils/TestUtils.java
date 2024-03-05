package com.meli.obtenerdiploma.utils;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public class TestUtils {

    private static String SCOPE;


    public static SubjectDTO generateSubjectDto(String name, Double score){
        return  new SubjectDTO(name, score);
    }
    public static StudentDTO generateStudentDto(Long id, String name, String message, Double average, List<SubjectDTO> subjects){
        return new StudentDTO(id, name, message, average, subjects);
    }

    public static List<SubjectDTO> generateGoodSubjects(){
        return List.of(
                generateSubjectDto("Sociales", 10.0),
                generateSubjectDto("Religion", 10.0),
                generateSubjectDto("Ciencia", 10.0)
        );
    }

    public static List<SubjectDTO> generateBadSubjects(){
        return List.of(
                generateSubjectDto("Sociales", 1.0),
                generateSubjectDto("Religion", 1.0),
                generateSubjectDto("Ciencia", 1.0)
        );
    }

    public static StudentDTO generateGoodStudentDto(){
        return new StudentDTO(
                1L,
                "pepe",
                "El alumno pepe ha obtenido un promedio de 10. Felicitaciones!",
                10.0,
                generateGoodSubjects()
        );
    }

    public static StudentDTO generateBadStudentDto(){
        return new StudentDTO(
                1L,
                "pepe",
                "El alumno pepe ha obtenido un promedio de 1. Puedes mejorar.",
                1.0,
                generateGoodSubjects()
        );
    }



    public static Set<StudentDTO> getAllStudents (){
        Set<StudentDTO> studentSet = new HashSet<>();
        studentSet.add(generateStudentDto(
                1L,
                "Juan",
                null,
                null,
                List.of(
                        generateSubjectDto("Matemática", 9.0),
                        generateSubjectDto("Física", 7.0),
                        generateSubjectDto("Química", 6.0)
                )
        ));

        studentSet.add(generateStudentDto(
                2L,
                "Pedro",
                null,
                null,
                List.of(
                        generateSubjectDto("Matemática", 10.0),
                        generateSubjectDto("Física", 8.0),
                        generateSubjectDto("Química", 4.0)
                )
        ));
        return studentSet;
    }

    public static StudentDTO generateStudent2(){
            return (generateStudentDto(
                    2L,
                    "Pedro",
                    null,
                    null,
                    List.of(
                            generateSubjectDto("Matemática", 10.0),
                            generateSubjectDto("Física", 8.0),
                            generateSubjectDto("Química", 4.0)
                    )
            ));
    }

    public static StudentDTO generateStudent1(){
        return (generateStudentDto(
                1L,
                "Juan",
                null,
                null,
                List.of(
                        generateSubjectDto("Matemática", 9.0),
                        generateSubjectDto("Física", 7.0),
                        generateSubjectDto("Química", 6.0)
                )
        ));
    }

    public static void emptyUsersFile() {
        Properties properties = new Properties();

        try {
            properties.load(new ClassPathResource("application.properties").getInputStream());
            SCOPE = properties.getProperty("api.scope");
        } catch (IOException e) {
            e.printStackTrace();
        }

        PrintWriter writer = null;

        try {
            writer = new PrintWriter(ResourceUtils.getFile("./src/" + SCOPE + "/resources/users.json"));
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        writer.print("[]");
        writer.close();
    }
}
