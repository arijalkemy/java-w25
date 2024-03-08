package com.meli.obtenerdiploma.integrationtest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import java.util.ArrayList;
import java.util.List;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    //Escenario Ok comparando un unico atributo
    @Test
    void analyzeScoresTestOk1() throws Exception {

        this.mockMvc.perform(get("/analyzeScores/{studentId}", "2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.studentName").value("Pedro"));

    }

    //Escenario feliz comparando objetos
    @Test
    void analyzeScoresTestOk2() throws Exception {

        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("MatemÃ¡tica", 10.0) );
        subjects.add(new SubjectDTO("FÃ\u00ADsica", 8.0) );
        subjects.add(new SubjectDTO("QuÃ\u00ADmica", 4.0) );

        StudentDTO responseDTO = new StudentDTO(2L, "Pedro", "El alumno Pedro ha obtenido un promedio de 7,33. Puedes mejorar.",7.333333333333333,  subjects);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String responseJson = writer.writeValueAsString(responseDTO);

        MvcResult mvcResult = this.mockMvc.perform(get("/analyzeScores/{studentId}", "2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(responseJson, mvcResult.getResponse().getContentAsString());

    }

    //Escenario triste con manejo de excepciones
    @Test
    void analyzeScoresTestFail() throws Exception {

        this.mockMvc.perform(get("/analyzeScores/{studentId}", "5"))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("StudentNotFoundException"));

    }



}
