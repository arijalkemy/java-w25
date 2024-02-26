package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.text.DecimalFormat;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class ObetenerDiplomaApplicationTests {

	@Mock
	private IStudentDAO studentDAO;

	@Mock
	private IStudentRepository studentRepository;

	@Mock
	private IStudentService studentServiceMock;

	@Mock
	private IObtenerDiplomaService obtenerDiplomaServiceMock;

	@InjectMocks
	private ObtenerDiplomaService obtenerDiplomaService;

	@InjectMocks
	private StudentService studentService;

	@InjectMocks
	private ObtenerDiplomaController obtenerDiplomaController;

	@InjectMocks
	private StudentController studentController;

	//EJ2
	@Test
	void analyzeScoresOk() {
		//Arrange
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setId(1L);
		studentDTO.setStudentName("Juan");
		studentDTO.setSubjects(getThreeSubjects());
		String message = "El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.";
		when(studentDAO.findById(1L)).thenReturn(studentDTO);
		//Act
		obtenerDiplomaService.analyzeScores(1L);
		//Assert
		//assertNotNull(studentDTO);
		assertEquals(studentDTO.getMessage(), message);
		assertEquals(new DecimalFormat("#.##").format(studentDTO.getAverageScore()), new DecimalFormat("#.##").format(7.33));
	}

	//No forzar test -> informar bugs
	/*@Test
	void analyzeScoresThrowStudentNotFoundException(){
		//Arrange
		Long studentId = 3L;
		//Act & Assert
		//Queda este, esta bien que devuelva null.
		assertThrows(NullPointerException.class, () -> obtenerDiplomaService.analyzeScores(studentId));
	}*/

	// data
	public List<SubjectDTO> getThreeSubjects() {
		return Arrays.asList(
				new SubjectDTO("Matemática", 9.0),
				new SubjectDTO("Física", 7.0),
				new SubjectDTO("Química", 6.0)
		);
	}

	//EJ3
	@Test
	void createOKTest(){
		//Arrange
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setId(1L);
		studentDTO.setStudentName("Juan");
		studentDTO.setSubjects(getThreeSubjects());
		// Act
		studentService.create(studentDTO);
		//Assert
		verify(studentDAO, atLeast(1)).save(studentDTO);
	}

	@Test
	void readOkTest(){
		//Arrange
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setId(1L);
		studentDTO.setStudentName("Juan");
		studentDTO.setSubjects(getThreeSubjects());
		Long userId = studentDTO.getId();
		//Act
		when(studentDAO.findById(userId)).thenReturn(studentDTO);//Rellena comportamiento del metodo en tiempo de compilacion
		StudentDTO result = studentService.read(userId);
		//Assert
		assertEquals(studentDTO,result);
	}

	@Test
	void updateOKTest(){
		//Arrange
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setId(1L);
		studentDTO.setStudentName("Juan");
		studentDTO.setSubjects(getThreeSubjects());
		// Act
		studentService.update(studentDTO);
		//Assert
		verify(studentDAO, atLeast(1)).save(studentDTO);
	}

	@Test
	void deleteOkTest(){
		//Arrange
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setId(1L);
		studentDTO.setStudentName("Juan");
		studentDTO.setSubjects(getThreeSubjects());
		// Act
		studentService.delete(studentDTO.getId());
		//Assert
		verify(studentDAO, atLeast(1)).delete(studentDTO.getId());
	}

	@Test
	void getAllOkTest(){
		//Arrange
		StudentDTO studentDTO1 = new StudentDTO();
		studentDTO1.setId(1L);
		studentDTO1.setStudentName("Juan");
		studentDTO1.setSubjects(getThreeSubjects());
		StudentDTO studentDTO2 = new StudentDTO();
		studentDTO2.setId(1L);
		studentDTO2.setStudentName("Ramon");
		studentDTO2.setSubjects(getThreeSubjects());
		Set<StudentDTO> expectedStudentDTOList = new HashSet<>();
		expectedStudentDTOList.add(studentDTO1);
		expectedStudentDTOList.add(studentDTO2);
		//Act
		when(studentRepository.findAll()).thenReturn(expectedStudentDTOList);
		Set<StudentDTO> currentStudentDTO = studentService.getAll();
		//Assert
		verify(studentRepository, atLeast(1)).findAll();
		assertEquals(expectedStudentDTOList, currentStudentDTO);
	}

	//EJ4
	@Test
	void obtenerDiplomaControllerOKTest(){
		//Arrange
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setId(1L);
		studentDTO.setStudentName("Juan");
		studentDTO.setSubjects(getThreeSubjects());
		studentDTO.setMessage("El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.");
		studentDTO.setAverageScore(7.33);
		//Act
		when(obtenerDiplomaServiceMock.analyzeScores(studentDTO.getId())).thenReturn(studentDTO);
		StudentDTO result = obtenerDiplomaController.analyzeScores(studentDTO.getId());
		//Assert
		assertEquals(studentDTO,result);
	}

	//EJ5
	@Test
	void registerStudentControllerOkTest(){
		//Arrange
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setId(1L);
		studentDTO.setStudentName("Juan");
		studentDTO.setSubjects(getThreeSubjects());
		//Act
		ResponseEntity<?> result = studentController.registerStudent(studentDTO);
		//Assert
		verify(studentServiceMock, atLeast(1)).create(studentDTO);
		assertEquals(ResponseEntity.ok(null), result);
	}

	@Test
	void getStudentOKTest(){
		//Arrange
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setId(1L);
		studentDTO.setStudentName("Juan");
		studentDTO.setSubjects(getThreeSubjects());
		//Act
		when(studentServiceMock.read(studentDTO.getId())).thenReturn(studentDTO);
		StudentDTO result = studentController.getStudent(studentDTO.getId());
		//Assert
		assertEquals(studentDTO,result);
	}

	@Test
	void modifyStudentControllerOkTest(){
		//Arrange
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setId(1L);
		studentDTO.setStudentName("Juan");
		studentDTO.setSubjects(getThreeSubjects());
		//Act
		ResponseEntity<?> result = studentController.modifyStudent(studentDTO);
		//Assert
		verify(studentServiceMock, atLeast(1)).update(studentDTO);
		assertEquals(ResponseEntity.ok(null), result);
	}
	@Test
	void removeStudentControllerOkTest(){
		//Arrange
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setId(1L);
		studentDTO.setStudentName("Juan");
		studentDTO.setSubjects(getThreeSubjects());
		//Act
		ResponseEntity<?> result = studentController.removeStudent(studentDTO.getId());
		//Assert
		verify(studentServiceMock, atLeast(1)).delete(studentDTO.getId());
		assertEquals(ResponseEntity.ok(null), result);
	}

	@Test
	void listStudentsOKTest(){
		//Arrange
		StudentDTO studentDTO1 = new StudentDTO();
		studentDTO1.setId(1L);
		studentDTO1.setStudentName("Juan");
		studentDTO1.setSubjects(getThreeSubjects());
		StudentDTO studentDTO2 = new StudentDTO();
		studentDTO2.setId(1L);
		studentDTO2.setStudentName("Ramon");
		studentDTO2.setSubjects(getThreeSubjects());
		Set<StudentDTO> expectedStudentDTOList = new HashSet<>();
		expectedStudentDTOList.add(studentDTO1);
		expectedStudentDTOList.add(studentDTO2);
		//Act
		when(studentServiceMock.getAll()).thenReturn(expectedStudentDTOList);
		Set<StudentDTO> resultStudentsDTO = studentController.listStudents();
		//Assert
		verify(studentServiceMock, atLeast(1)).getAll();
		assertEquals(expectedStudentDTOList, resultStudentsDTO);
	}
}