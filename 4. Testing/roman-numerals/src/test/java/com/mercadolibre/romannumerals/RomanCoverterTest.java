package com.mercadolibre.romannumerals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class RomanCoverterTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void roman1TestOk() throws Exception {
        String romanExpected = "I";
        MvcResult result = mockMvc.perform(get("/{number}",1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8")).andReturn();

        assertEquals(romanExpected, result.getResponse().getContentAsString());
    }
    @Test
    void roman3TestOK() throws  Exception{
        String romanExpected = "III";
        MvcResult result = mockMvc.perform(get("/{number}",3))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andReturn();
        assertEquals(romanExpected, result.getResponse().getContentAsString());
    }

    @Test
    void roman5TestOK() throws Exception{
        String romanExpected = "V";
        mockMvc.perform(get("/{number}",5))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(romanExpected)));
    }

    @Test
    void roman7TestOk() throws Exception{
        String romanExpecte = "VII";
        mockMvc.perform(get("/{rumber}",7))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(romanExpecte)));
    }

    @Test
    void roman10TestOk()throws Exception{
        String romanExpected = "X";
        mockMvc.perform(get("/{number}",10))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(romanExpected)));
    }

    @Test
    void roman50TestOk() throws Exception{
        String rommanExpecte = "L";
        mockMvc.perform(get("/{number}",50))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(rommanExpecte)));

    }
}
