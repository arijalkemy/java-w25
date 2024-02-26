package com.meli.obtenerdiploma;

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
class ObetenerDiplomaApplicationTests {

	FactoryStudent f = new FactoryStudent();
	@Mock // No se pueden poner varios mocks, pero si varios inject Mocks
	StudentDAO studentDAO;

	@InjectMocks
	private ObtenerDiplomaService obtenerDiplomaService;  // Tincho dijo q es mejor poner la clase directamente para evitar poner el contexto

	@Test
	public void analyzeScoresTestOK () {
		// Arrange
		FactoryStudent f = new FactoryStudent();
		StudentDTO studentBase = f.getPedroStudent();
		StudentDTO studentExpected = f.getStudentObtenerDiplomaExpectedTest();
		// Verify es solo por si el metodo devuelve void, para saber si lo hizo o no
		when(studentDAO.findById(anyLong())).thenReturn(studentBase);
		// Act
		StudentDTO studentDTOresponse = obtenerDiplomaService.analyzeScores(anyLong());
		// Assert
		assertEquals(studentExpected, studentDTOresponse);
	}

	/*
	cASOS DE TEST:
	1- Excepciones que se crean en el metodo que estamos testeando
	2- El caso correcto del metodo
	3- Casos de bifurcaciones, tanto porq hay if o switch. ( + de 1 )
	 */
}