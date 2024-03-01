package com.meli.obtenerdiploma;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Disabled
@SpringBootTest
@AutoConfigureMockMvc
public class PracticaTestIntegracion25 {
    @Autowired
    MockMvc mockMvc;
/*
    @Test
    void helloWorldTestOk() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/sayHello"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Hello World!"))
                .andReturn();

        assertEquals("application/json", mvcResult.getResponse().getContentType());
    }

    @Test
    void helloWorldTestOk2() throws Exception {
        mockMvc.perform(get("/sayHello/{name}", "Martin"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("Hello World!"));
    }

    @Test
    void helloWorldTestOk3() throws Exception {
        mockMvc.perform(get("/sayHello2")
                        .param("name", "Martin"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("Hello Martin!"));
    }

    @Test
    void helloWorldTestOk4() throws Exception {
        TestPostDto testPostDto = new TestPostDto("Martin");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String jsonPayload = writer.writeValueAsString(testPostDto);


        mockMvc.perform(post("/postHello")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("Hello Martin!"));
    }

    @Test
    void helloWorldTestOk5() throws Exception {
        TestPostDto testPostDto = new TestPostDto("Martin");

        ResponseDto expectedDto = new ResponseDto(1, "Hello Martin");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String jsonPayload = writer.writeValueAsString(testPostDto);
        String expected = writer.writeValueAsString(expectedDto);


        MvcResult mvcResult = mockMvc.perform(post("/postHello")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(expected, mvcResult.getResponse().getContentAsString());
    }
 */
}
