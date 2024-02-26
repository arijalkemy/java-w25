package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ObetenerDiplomaApplicationTests {
	@Mock
	IStudentDAO studentDAO;

	@InjectMocks
	StudentService service;




	@Test
	public void contextLoads() {

	}
}