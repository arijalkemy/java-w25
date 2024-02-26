package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class ObtenerDiplomaApplicationTests {
	@Mock
	IStudentDAO studentDAO;
	@InjectMocks
	ObtenerDiplomaService obtenerDiplomaService;

	@DisplayName("Ejercicio 2 - caso avg < 9")
	@Test
	public void analyzeScoresLowAverageTest() {
		//Arrange
		Double expectedAverage = 8.0;

		StudentDTO student = new StudentDTO(100L,"name", "", 0.0, List.of(new SubjectDTO("Math", 6.0), new SubjectDTO("Gym", 10.0)));

		when(studentDAO.findById(anyLong())).thenReturn(student);

		//Act
		StudentDTO currentStudent = obtenerDiplomaService.analyzeScores(anyLong());

		//Assert
		assertThat(currentStudent.getAverageScore()).isEqualTo(expectedAverage);
		assertThat(currentStudent.getMessage()).contains("Puedes mejorar.");
	}

	@DisplayName("Ejercicio 2 - caso avg > 9")
	@Test
	public void analyzeScoresHighAverageTest() {
		//Arrange
		Double expectedAverage = 9.5;
		StudentDTO student = new StudentDTO(100L,"name", "", 0.0, List.of(new SubjectDTO("Math", 9.0), new SubjectDTO("Gym", 10.0)));
		when(studentDAO.findById(anyLong())).thenReturn(student);
		//Act
		StudentDTO currentStudent = obtenerDiplomaService.analyzeScores(anyLong());
		//Assert
		assertThat(currentStudent.getAverageScore()).isEqualTo(expectedAverage);
		assertThat(currentStudent.getMessage()).contains("Felicitaciones!");
	}

	@Mock
	IObtenerDiplomaService iObtenerDiplomaService;
	@InjectMocks
	ObtenerDiplomaController obtenerDiplomaController;

	@DisplayName("Ejercicio 4")
	@Test
	public void analyzeScoresControllerTest() {
		//Arrange
		StudentDTO student = new StudentDTO(1L, "Juan", "Felicitaciones", 7.3, List.of(new SubjectDTO("Matemática", 9.0), new SubjectDTO("Física", 7.0),new SubjectDTO("Química", 6.0)));
		when(iObtenerDiplomaService.analyzeScores(student.getId())).thenReturn(student);
		//Act
		StudentDTO currentStudent = obtenerDiplomaController.analyzeScores(1L);
		//Assert
		assertThat(currentStudent.getMessage()).contains(student.getMessage());
		assertThat(currentStudent.getAverageScore()).isEqualTo(student.getAverageScore());
		assertThat(currentStudent.getStudentName()).isEqualTo(student.getStudentName());
	}
}