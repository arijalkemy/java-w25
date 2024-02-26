package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ObetenerDiplomaApplicationTests {

	@Mock
	IStudentDAO studentDAO;
	@InjectMocks
	ObtenerDiplomaService obtenerDiplomaService;

	@Test
	@DisplayName("0001| OK")
	void analyzeScoresOkTest(){
		//ARRANGE
		Long userId = 1L;
		StudentDTO expectedStudentDTO = new StudentDTO(userId,"Pedro",null,null, List.of(
				new SubjectDTO("Matemática",10.0),
				new SubjectDTO("Física",  7.0),
				new SubjectDTO("Química",  6.0)
		));
		when(studentDAO.findById(userId)).thenReturn(expectedStudentDTO);
		//ACT
		StudentDTO actualStudentDTO = obtenerDiplomaService.analyzeScores(userId);
		//ASSERT
		assertEquals(expectedStudentDTO,actualStudentDTO);
	}
}