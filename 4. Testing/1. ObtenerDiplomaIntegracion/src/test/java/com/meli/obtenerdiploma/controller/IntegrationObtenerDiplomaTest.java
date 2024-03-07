package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.ErrorDTO;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class IntegrationObtenerDiplomaTest {

    @Autowired
    MockMvc mockMvc;

    static ObjectWriter writer;

    @BeforeAll
    static void setup(){
        writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE,false).writer();
    }

    @Test
    void okTest() throws Exception {

        StudentDTO studentDTO = TestUtilsGenerator.getStudentWithId(1L);
        String expected = writer.writeValueAsString(studentDTO);
        MvcResult mvcResult = this.mockMvc.perform(get("/analyzeScores/{studentId}",1))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(expected,mvcResult.getResponse().getContentAsString());

    }

    @Test
    void errorTest() throws Exception {

        ErrorDTO errorDTO = new ErrorDTO("","");

        String jsonError = writer.writeValueAsString(errorDTO);
        mockMvc.perform(get("/analyzeScores/","3"))
                .andDo(print())
                .andExpect(content().contentType("application/json"));

    }

    @Test
    public void testRegisterStudent() throws Exception{
        //StudentDTO studentDTO = new StudentDTO(1l,"Julian","Aprobado",);

    }



}

