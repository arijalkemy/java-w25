package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentControllerTest {

    @Mock
    IStudentService studentService;
    @InjectMocks
    StudentController studentController;

    @Test
    void registerStudentOK(){
        StudentDTO mockStudent = new StudentDTO(
                1L,
                "Juan Manuel",
                "",
                0D,
                Arrays.asList(
                        new SubjectDTO(
                                "Matematicas",
                                10.0
                        ),
                        new SubjectDTO(
                                "Ciencias",
                                10.0
                        )
                )
        );

        studentController.registerStudent(mockStudent);

        verify(studentService, atLeast(1)).create(mockStudent);
    }
    @Test
    void registerStudentBlankName(){
        StudentDTO mockStudent = new StudentDTO(
                1L,
                "",
                "",
                0D,
                Arrays.asList(
                        new SubjectDTO(
                                "Matematicas",
                                10.0
                        ),
                        new SubjectDTO(
                                "Ciencias",
                                10.0
                        )
                )
        );

        //Assertions.assertThrows(MethodArgumentNotValidException.class,
        // () -> studentController.registerStudent(mockStudent));
    }
    @Test
    void registerStudentWrongName(){

    }
    @Test
    void registerStudentNameTooLong(){

    }
    @Test
    void registerStudentEmptySubjects(){

    }
    @Test
    void getStudentOK(){
        StudentDTO mockStudent = new StudentDTO(
                1L,
                "",
                "",
                0D,
                Arrays.asList(
                        new SubjectDTO(
                                "Matematicas",
                                10.0
                        ),
                        new SubjectDTO(
                                "Ciencias",
                                10.0
                        )
                )
        );
        when(studentService.read(anyLong())).thenReturn(mockStudent);

        StudentDTO studentDTOObtained = studentController.getStudent(1L);

        assertThat(studentDTOObtained).usingRecursiveComparison().isEqualTo(mockStudent);
    }
    @Test
    void getStudentNotFoundStudent(){
        when(studentService.read(anyLong())).thenThrow(StudentNotFoundException.class);

        Assertions.assertThrows(StudentNotFoundException.class,
                () -> studentController.getStudent(1L));

    }
    @Test
    void modifyStudentOK(){
        StudentDTO mockStudent = new StudentDTO(
                1L,
                "Juan Manuel",
                "",
                0D,
                Arrays.asList(
                        new SubjectDTO(
                                "Matematicas",
                                10.0
                        ),
                        new SubjectDTO(
                                "Ciencias",
                                10.0
                        )
                )
        );

        studentController.modifyStudent(mockStudent);

        verify(studentService, atLeast(1)).update(mockStudent);

    }
    @Test
    void modifyStudentBlankName(){

    }
    @Test
    void modifyStudentWrongName(){

    }
    @Test
    void modifyStudentNameTooLong(){

    }
    @Test
    void modifyStudentNoSubjects(){

    }
    @Test
    void removeStudentOK(){
        studentController.removeStudent(1L);
        verify(studentService, atLeast(1)).delete(1L);
    }
    @Test
    void listStudentsOK(){
        Set<StudentDTO> studentsListMock = new HashSet<>();
        studentsListMock.add(new StudentDTO(
                1L,
                "Juan Manuel",
                "",
                0D,
                Arrays.asList(
                        new SubjectDTO(
                                "Matematicas",
                                10.0
                        ),
                        new SubjectDTO(
                                "Ciencias",
                                10.0
                        )
                )));
        studentsListMock.add(new StudentDTO(
                1L,
                "Juan Manuel",
                "",
                0D,
                Arrays.asList(
                        new SubjectDTO(
                                "Matematicas",
                                10.0
                        ),
                        new SubjectDTO(
                                "Ciencias",
                                10.0
                        )
                )));
        studentsListMock.add(new StudentDTO(
                1L,
                "Juan Manuel",
                "",
                0D,
                Arrays.asList(
                        new SubjectDTO(
                                "Matematicas",
                                10.0
                        ),
                        new SubjectDTO(
                                "Ciencias",
                                10.0
                        )
                )));
        when(studentService.getAll()).thenReturn(studentsListMock);

        Set<StudentDTO> studentsListObtained = studentController.listStudents();

        assertThat(studentsListObtained).usingRecursiveComparison().isEqualTo(studentsListMock);
    }
}
