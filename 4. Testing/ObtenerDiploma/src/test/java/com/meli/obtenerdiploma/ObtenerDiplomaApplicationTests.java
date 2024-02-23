package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaApplicationTests {

	@Mock
	private IStudentDAO studentDAO;
	@InjectMocks
	private ObtenerDiplomaService obtenerDiplomaService;



	@Test
	public void analyzeScoresTestOk() {
		//ARRANGE
		Long studentId = 1L;
		StudentDTO studentExpected = new StudentDTO(studentId,
				"Carlitos", "Test", 5.5,
				new ArrayList<SubjectDTO>()
		);

		when(studentDAO.findById(studentId)).thenReturn(studentExpected);

		//ACT

		StudentDTO result = obtenerDiplomaService.analyzeScores(studentId);
		//ASSERT
		assertEquals(studentExpected,result);
	}

}