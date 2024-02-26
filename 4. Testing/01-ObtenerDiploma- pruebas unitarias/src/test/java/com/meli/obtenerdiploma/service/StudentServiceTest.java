package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
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
    public void createStudentOk(){

        StudentDTO studentDTO = new StudentDTO();
        List<SubjectDTO> subjectDTOS = new ArrayList<>();

        subjectDTOS.add(new SubjectDTO("matematicas",5.0));
        subjectDTOS.add(new SubjectDTO("español",8.0));
        subjectDTOS.add(new SubjectDTO("ingles",9.0));

        studentDTO.setStudentName("Andres");
        studentDTO.setSubjects(subjectDTOS);

        studentService.create(studentDTO);

        verify(studentDAO,atLeast(1)).save(any());

    }

    @Test
    public void readOk(){
        StudentDTO studentDTO = new StudentDTO();
        List<SubjectDTO> subjectDTOS = new ArrayList<>();

        subjectDTOS.add(new SubjectDTO("matematicas",5.0));
        subjectDTOS.add(new SubjectDTO("español",8.0));
        subjectDTOS.add(new SubjectDTO("ingles",9.0));

        studentDTO.setStudentName("Andres");
        studentDTO.setSubjects(subjectDTOS);

        when(studentDAO.findById(anyLong())).thenReturn(studentDTO);

        StudentDTO studentRead = studentService.read(1L);

        assertEquals(studentDTO,studentRead);

    }



    @Test
    public void updateOk(){
        StudentDTO studentDTO = new StudentDTO();
        List<SubjectDTO> subjectDTOS = new ArrayList<>();

        subjectDTOS.add(new SubjectDTO("matematicas",5.0));
        subjectDTOS.add(new SubjectDTO("español",8.0));
        subjectDTOS.add(new SubjectDTO("ingles",9.0));

        studentDTO.setStudentName("Andres");
        studentDTO.setSubjects(subjectDTOS);

        studentService.update(studentDTO);

        verify(studentDAO,atLeast(1)).save(any());
    }

    @Test
    public void deleteOk(){
        StudentDTO studentDTO = new StudentDTO();
        List<SubjectDTO> subjectDTOS = new ArrayList<>();

        subjectDTOS.add(new SubjectDTO("matematicas",5.0));
        subjectDTOS.add(new SubjectDTO("español",8.0));
        subjectDTOS.add(new SubjectDTO("ingles",9.0));

        studentDTO.setStudentName("Andres");
        studentDTO.setSubjects(subjectDTOS);

        //when(studentDAO.findById(anyLong())).thenReturn(studentDTO);

        studentService.delete(anyLong());

        verify(studentDAO,atLeast(1)).delete(anyLong());


    }
      @Test
    public void getAllOk(){
        StudentDTO studentDTO = new StudentDTO();
        List<SubjectDTO> subjectDTOS = new ArrayList<>();

        subjectDTOS.add(new SubjectDTO("matematicas",5.0));
        subjectDTOS.add(new SubjectDTO("español",8.0));
        subjectDTOS.add(new SubjectDTO("ingles",9.0));

        studentDTO.setStudentName("Andres");
        studentDTO.setSubjects(subjectDTOS);

          Set<StudentDTO> studentDTOS = new HashSet<>();
          studentDTOS.add(studentDTO);
          studentDTOS.add(studentDTO);
          studentDTOS.add(studentDTO);
          studentDTOS.add(studentDTO);
          studentDTOS.add(studentDTO);


        when(studentRepository.findAll()).thenReturn(studentDTOS);

        Set<StudentDTO> students = studentService.getAll();

        assertTrue(students.size() > 0);

    }







}
