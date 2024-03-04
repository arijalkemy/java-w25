package com.meli.obtenerdiploma.unitTests;

import com.meli.obtenerdiploma.ObtenerDiplomaApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ObtenerDiplomaApplicationTests {

    @Autowired
    private ApplicationContext context;

    @Test
    void contextLoads() {
        assertThat(context).isNotNull();
    }

    @Test
    void main_startsApplication() {
        // Aquí invocamos el método main
        ObtenerDiplomaApplication.main(new String[] {});

        // Luego, puedes agregar las verificaciones que necesites para asegurarte de que tu aplicación se está comportando como esperas.
        // Por ejemplo, podrías verificar que ciertos beans estén presentes en el contexto de la aplicación,
        // o que ciertos servicios estén en un estado esperado.
    }
}