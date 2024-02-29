package com.mercadolibre.be_java_hisp_w25_g15.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.be_java_hisp_w25_g15.dto.response.UserDto;

import com.mercadolibre.be_java_hisp_w25_g15.dto.response.UserListDto;
import com.mercadolibre.be_java_hisp_w25_g15.model.Buyer;
import com.mercadolibre.be_java_hisp_w25_g15.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void intAllUsersTest()throws Exception{
        ObjectWriter mapper = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

                List<UserListDto> users = List.of(
                        new UserListDto(1,"Tony Stark"),
                        new UserListDto(2,"Luca"),
                        new UserListDto(3,"Martin"),
                        new UserListDto(4,"Santiago"),
                        new UserListDto(5,"Orlando"),
                        new UserListDto(6,"Miguel"),
                        new UserListDto(7,"Samuel"),
                        new UserListDto(8,"Tony Stark")
                );

        String listJSON = mapper.writeValueAsString(users);

        MvcResult mvcResult = mockMvc.perform(get("/users/get-users"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        assertEquals(listJSON, mvcResult.getResponse().getContentAsString());
    }


}
