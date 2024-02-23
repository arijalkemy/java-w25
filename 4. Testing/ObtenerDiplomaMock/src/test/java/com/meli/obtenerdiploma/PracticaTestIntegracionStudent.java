package com.meli.obtenerdiploma;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PracticaTestIntegracionStudent {
/*
Se requiere crear los tests de integración necesarios para cubrir el comportamiento
de la capa de los controladores ObtenerDiplomaController y StudentController.
 Tener en cuenta múltiples escenarios, incluidos las validaciones, mensajes de error y Excepciones.
 */
    @Autowired
    MockMvc mockMvc;

    @Test
    void getStudentTestHappyPath() throws Exception{
        MvcResult mvcResult = mockMvc.perform(get("/getStudent/{id}",2L))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("El alumno Pedro ha obtenido un promedio de 7.33. Puedes mejorar."))
                .andReturn();
    }

}
