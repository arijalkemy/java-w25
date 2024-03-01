package com.socialMeli;

import com.socialMeli.SocialMeliApplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SocialMeliApplicationTests {

	@Test
	void contextLoads() {
		try {
			SocialMeliApplication.main(new String[]{});
			// Si el método main se ejecuta sin excepciones, se considera que el contexto se cargó correctamente
		} catch (Exception e) {
			Assertions.fail("Error al cargar el contexto de la aplicación: " + e.getMessage());
		}
	}

}
