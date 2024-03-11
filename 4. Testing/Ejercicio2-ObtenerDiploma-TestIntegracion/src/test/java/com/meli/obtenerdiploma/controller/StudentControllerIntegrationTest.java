package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    MvcResult mvcResult;

    @Test
    public void registerStudentTestOk() throws Exception {
        StudentDTO payloadDTO = new StudentDTO(4L,"Student Name", null, null , List.of(
                new SubjectDTO("Sociales",0.0),
                new SubjectDTO("Algebra",5.0)
        ));

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(payloadDTO);

        mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isOk())
                .andReturn();

        assertNull(mvcResult.getResponse().getContentType(),"content Type must be null");

    }


}
