package com.mercadolibre.starwars.controllers.integralTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FindControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void findSuccess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/Darth")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void findNameSuccess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/Yoda")).
                andDo(print()).
                andExpect(MockMvcResultMatchers.jsonPath("$").isArray()).
                andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Yoda"));
    }

    @Test
    public void findUnsuccess() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/Annie")).andDo(print()).andExpect(status().isOk()).andReturn();

        Assertions.assertEquals("[]",result.getResponse().getContentAsString());
    }

}
