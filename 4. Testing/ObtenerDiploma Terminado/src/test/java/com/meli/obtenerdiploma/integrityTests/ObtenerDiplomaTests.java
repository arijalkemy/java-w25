package com.meli.obtenerdiploma.integrityTests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
public class ObtenerDiplomaTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    void studentInexistentTest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/3"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    void studentExistentTest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value("Juan"));
    }
}
