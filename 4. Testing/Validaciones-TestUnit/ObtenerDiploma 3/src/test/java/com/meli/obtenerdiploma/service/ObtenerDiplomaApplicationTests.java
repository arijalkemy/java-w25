package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import utils.FactoryStudent;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaApplicationTests {

	FactoryStudent f = new FactoryStudent();
	@Mock
	StudentDAO studentDAO;

	@InjectMocks
	private ObtenerDiplomaService obtenerDiplomaService;

	@Test
	public void analyzeScoresTestOK () {
		// Arrange
		StudentDTO studentBase = f.getStudent();
		StudentDTO studentExpected = f.getStudentObtenerDiplomaExpectedTest();
		when(studentDAO.findById(anyLong())).thenReturn(studentBase);
		// Act
		StudentDTO studentDTOresponse = obtenerDiplomaService.analyzeScores(anyLong());
		// Assert
		assertEquals(studentExpected, studentDTOresponse);
	}
}