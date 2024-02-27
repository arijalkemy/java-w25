package com.mercadolibre.romannumerals;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
class RomanNumeralsRestControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @SneakyThrows
    @Test
    void toRomanReturnsOne() {
        MvcResult mvcResult = mockMvc.perform(get("/{number}",1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("I"))
                .andReturn();
    }

    @SneakyThrows
    @Test
    void toRomanReturnsThree() {
        MvcResult mvcResult = mockMvc.perform(get("/{number}",3))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("III"))
                .andReturn();
    }

    @SneakyThrows
    @Test
    void toRomanReturnsFive() {
        MvcResult mvcResult = mockMvc.perform(get("/{number}",5))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("V"))
                .andReturn();
    }

    @SneakyThrows
    @Test
    void toRomanReturnsSeven() {
        MvcResult mvcResult = mockMvc.perform(get("/{number}",7))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("VII"))
                .andReturn();
    }

    @SneakyThrows
    @Test
    void toRomanReturnsTen() {
        MvcResult mvcResult = mockMvc.perform(get("/{number}",10))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("X"))
                .andReturn();
    }

    @SneakyThrows
    @Test
    void toRomanReturnsFifty() {
        MvcResult mvcResult = mockMvc.perform(get("/{number}",50))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("L"))
                .andReturn();
    }
}