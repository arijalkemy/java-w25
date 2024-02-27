package com.meli.obtenerdiploma.serviceTest;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class StudentServiceTest {
    @Mock
    IStudentDAO studentDAO;
    @Mock
    IStudentRepository studentRepository;
    @InjectMocks
    StudentService studentService;

    @Test
    void createTest(){
        //ARRANGE
        List<SubjectDTO> subjectDTOList = new ArrayList<>(Arrays.asList(
                new SubjectDTO("Calculo",4.30),
                new SubjectDTO("Ingles",4.30)
        ));
        StudentDTO studentDTO = new StudentDTO(1L, "Pedro", "El alumno Pedro ha obtenido un promedio de 4.30. Felicitaciones!" , 4.30, subjectDTOList);
      
        //ACT y ASSERT
        verify(studentDAO,atLeast(1)).save(any());
        //verify(nombreDeServicio, atLeats(1)).nombreDelMetodo();

    }
    @Test
    void readTest(){
        //Arr

        List<SubjectDTO> subjectDTOList = new ArrayList<>(Arrays.asList(
                new SubjectDTO("Calculo",4.30),
                new SubjectDTO("Ingles",4.30)
        ));

        StudentDTO studentDtoAnswer = new StudentDTO(
                1L,
                "Pedro",
                "El alumno Pedro ha obtenido un promedio de 4.30. Felicitaciones!" ,
                4.30, subjectDTOList
        );

        // Act

        when(studentDAO.findById(anyLong())).thenReturn(studentDtoAnswer);
        StudentDTO myObtainedStudentDto = studentDAO.findById(1L);

        // Assert

        Assertions.assertEquals(studentDtoAnswer, myObtainedStudentDto);
    }

    @Test
    void updateTest(){

        // Arr

        List<SubjectDTO> subjectDTOList = new ArrayList<>(Arrays.asList(
                new SubjectDTO("Calculo",4.30),
                new SubjectDTO("Ingles",4.30)
        ));

        StudentDTO studentDtoUpdate = new StudentDTO(
                1L,
                "Pedro",
                "El alumno Pedro ha obtenido un promedio de 4.30. Felicitaciones!" ,
                4.30, subjectDTOList
        );

        // ActAndAssert
        studentDAO.save(studentDtoUpdate);
        verify(studentDAO,atLeast(1)).save(any());

    }
    @Test
    void deleteTest(){
        // ARR
        Long idToDelete = 1L;

        // Act and Assert
        studentDAO.delete(idToDelete);
        verify(studentService, atLeast(1)).delete(anyLong());

    }


    @Test
    @DisplayName("FindByIdTest - Status 404 - Student not found")
    void deleteStudentNotFoundTest(){

        Long StudentIdToSearch = 5L;

        List<SubjectDTO> subjectDTOList = new ArrayList<>(Arrays.asList(
                new SubjectDTO("Calculo",4.30),
                new SubjectDTO("Ingles",4.30)
        ));

        StudentDTO studentDtoFound = new StudentDTO(
                1L,
                "Pedro",
                "El alumno Pedro ha obtenido un promedio de 4.30. Felicitaciones!" ,
                4.30, subjectDTOList
        );


        // Creo que el metodo deberia volver un opcinoal...
        when(studentDAO.findById(anyLong())).thenReturn(studentDtoFound);

        Assertions.assertThrows(StudentNotFoundException.class,
                () -> studentDAO.delete(anyLong()));
    }




    @Test
    @DisplayName("GetAllTest - Status OK")
    void getAllTest(){

        // Arr
        Set<StudentDTO> expectedSet = new HashSet<>();

        List<SubjectDTO> subjectDTOList1 = new ArrayList<>(Arrays.asList(
                new SubjectDTO("Calculo",4.30),
                new SubjectDTO("Ingles",4.30)
        ));

        StudentDTO studentDto1 = new StudentDTO(
                1L,
                "Pedro",
                "El alumno Pedro ha obtenido un promedio de 4.30. Felicitaciones!" ,
                4.30, subjectDTOList1
        );

        List<SubjectDTO> subjectDTOList2 = new ArrayList<>(Arrays.asList(
                new SubjectDTO("Calculo",4.30),
                new SubjectDTO("Ingles",4.30)
        ));

        StudentDTO studentDto2 = new StudentDTO(
                1L,
                "Pedro",
                "El alumno Pedro ha obtenido un promedio de 4.30. Felicitaciones!" ,
                4.30, subjectDTOList2
        );

        expectedSet.add(studentDto1);
        expectedSet.add(studentDto2);



        // Act

        when(studentRepository.findAll()).thenReturn(expectedSet);

        Set<StudentDTO> returnedSet = studentService.getAll();

        // Assert

        Assertions.assertEquals(expectedSet, returnedSet);

    }

}
