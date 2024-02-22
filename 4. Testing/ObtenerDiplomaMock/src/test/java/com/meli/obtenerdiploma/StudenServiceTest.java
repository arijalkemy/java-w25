package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class StudenServiceTest {
    @Mock
    IStudentDAO studentDAO;
    @Mock
    IStudentRepository studentRepository;
    @InjectMocks
    StudentService studentService;

    @DisplayName("Ejercicio 3-create")
    @Test
    public void createOkTest(){
        //Arrange
        StudentDTO student = new StudentDTO(100L,"name", "", 0.0, List.of(new SubjectDTO("Math", 6.0), new SubjectDTO("Gym", 10.0)));
        //Act
        studentService.create(student);
        //Assert
        verify(studentDAO, atLeast(1)).save(student);
    }

    @DisplayName("Ejercicio 3-read")
    @Test
    public void readOkTest(){
        //Arrange - llama elementos a usar
        StudentDTO studentExpected = new StudentDTO(100L,"name", "", 0.0, List.of(new SubjectDTO("Math", 6.0), new SubjectDTO("Gym", 10.0)));
        when(studentDAO.findById(anyLong())).thenReturn(studentExpected);
        //Act - ejecuta el método a testear
        StudentDTO currentStudent = studentService.read(anyLong());
        //Assert - verifica que el resultado sea lo esperado
        assertThat(studentExpected).isEqualTo(currentStudent);
    }

    @DisplayName("Ejercicio 3-update")
    @Test
    public void updateOkTest(){
        //Arrange
        StudentDTO student = new StudentDTO(100L,"name", "", 0.0, List.of(new SubjectDTO("Math", 6.0), new SubjectDTO("Gym", 10.0)));
        //Act
        studentService.update(student);
        //Assert
        verify(studentDAO, atLeast(1)).save(student);
    }

    @DisplayName("Ejercico 3-delete")
    @Test
    public void deteleOkTest(){
        //Arrange
        //StudentDTO student = new StudentDTO(100L,"name", "", 0.0, List.of(new SubjectDTO("Math", 6.0), new SubjectDTO("Gym", 10.0)));
        //Act
        studentService.delete(anyLong());
        //Assert
        verify(studentDAO, atLeast(1)).delete(anyLong());
    }

    @DisplayName("Ejercicio 3-getAll")
    @Test
    public void getAllOkTest(){
        //Arrange - llama elementos a usar
        Set<StudentDTO> studentsSet = new HashSet<>();
        studentsSet.add(new StudentDTO(1L, "Juan", "", 0.0, List.of(new SubjectDTO("Matemática", 9.0), new SubjectDTO("Física", 7.0),new SubjectDTO("Química", 6.0))));
        studentsSet.add(new StudentDTO(2L, "Pedro", "", 0.0, List.of(new SubjectDTO("Matemática", 10.0), new SubjectDTO("Física", 8.0),new SubjectDTO("Química", 4.0))));
        when(studentRepository.findAll()).thenReturn(studentsSet);
        //Act - ejecuta el método a testear
        Set<StudentDTO> allStudentsList = studentService.getAll();
        //Assert - verifica que el resultado sea lo esperado
        assertThat(allStudentsList).isEqualTo(studentsSet);
    }
}
