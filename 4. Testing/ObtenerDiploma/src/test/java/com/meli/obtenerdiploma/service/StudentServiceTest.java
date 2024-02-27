package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
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
class StudentServiceTest {

    @Mock
    private IStudentDAO studentDAO;
    @Mock
    private IStudentRepository studentRepository;
    @InjectMocks
    private StudentService studentService;

    @Test
    void createOK(){
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

        studentService.create(mockStudent);

        verify(studentDAO, atLeast(1)).save(mockStudent);


    }
    @Test
    void readOK(){
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
        when(studentDAO.findById(anyLong())).thenReturn(mockStudent);

        StudentDTO studentObtainded = studentService.read(1L);

        assertThat(studentObtainded).usingRecursiveComparison().isEqualTo(mockStudent);

    }
    @Test
    void readStudentNotFound(){
        when(studentDAO.findById(2L)).thenThrow(StudentNotFoundException.class);

        Assertions.assertThrows(StudentNotFoundException.class, () -> studentService.read(2L));

    }
    @Test
    void updateOK(){
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

        studentService.update(mockStudent);

        verify(studentDAO, atLeast(1)).save(mockStudent);

    }
    @Test
    void deleteOK(){
        studentService.delete(1L);

        verify(studentDAO, atLeast(1)).delete(1L);

    }
    @Test
    void getAllOK(){
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
        when(studentRepository.findAll()).thenReturn(studentsListMock);

        Set<StudentDTO> studentListObtained = studentService.getAll();

        assertThat(studentListObtained).usingRecursiveComparison().isEqualTo(studentsListMock);

    }

}
