package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

class ObtenerDiplomaServiceTest {

	@Mock
	private IStudentDAO studentDAO;

	@InjectMocks
	private ObtenerDiplomaService obtenerDiplomaService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void analyzeScores_NullStudent_ReturnsNull() {
		// Arrange

		Long studentId = 1L;
		when(studentDAO.findById(studentId)).thenReturn(null);

		// Act
		StudentDTO result = obtenerDiplomaService.analyzeScores(studentId);

		// Assert
		assertNull(result);
	}

	@Test
	void analyzeScores_EmptySubjects_ReturnsMessage() {
		// Arrange
		Long studentId = 1L;
		StudentDTO studentDTO = new StudentDTO(studentId, "John Doe", Collections.emptyList());
		when(studentDAO.findById(1L)).thenReturn(studentDTO);

		// Act
		StudentDTO result = obtenerDiplomaService.analyzeScores(studentId);

		// Assert
		assertNotNull(result);
		assertEquals("El alumno John Doe ha obtenido un promedio de 0. Puedes mejorar.", result.getMessage());
	}

	@Test
	void analyzeScores_CalculateAverage_ReturnsCorrectAverage() {
		// Arrange
		Long studentId = 1L;
		List<SubjectDTO> subjects = Arrays.asList(
				new SubjectDTO("Math", 8.0),
				new SubjectDTO("Science", 7.0),
				new SubjectDTO("History", 9.0)
		);
		StudentDTO studentDTO = new StudentDTO(studentId, "John Doe", subjects);
		when(studentDAO.findById(studentId)).thenReturn(studentDTO);

		// Act
		StudentDTO result = obtenerDiplomaService.analyzeScores(studentId);

		// Assert
		assertNotNull(result);
		assertEquals(8.0, result.getAverageScore());
	}

	@Test
	void analyzeScores_HighAverage_ReturnsMessageWithHonors() {
		// Arrange
		Long studentId = 1L;
		List<SubjectDTO> subjects = Arrays.asList(
				new SubjectDTO("Math", 9.0),
				new SubjectDTO("Science", 10.0),
				new SubjectDTO("History", 9.5)
		);
		StudentDTO studentDTO = new StudentDTO(studentId, "John Doe", subjects);
		when(studentDAO.findById(studentId)).thenReturn(studentDTO);

		// Act
		StudentDTO result = obtenerDiplomaService.analyzeScores(studentId);

		// Assert
		assertNotNull(result);
		assertTrue(result.getMessage().contains("Felicitaciones"));
	}
}
