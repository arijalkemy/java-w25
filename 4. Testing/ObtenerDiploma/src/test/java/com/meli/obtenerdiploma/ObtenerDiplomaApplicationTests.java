package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class ObetenerDiplomaApplicationTests {

	@Mock
	private IStudentDAO studentDAO;

	@InjectMocks
	private ObtenerDiplomaService obtenerDiplomaService;

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
}