package com.mercadolibre.java_applications.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.eclipse.jetty.client.Response;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import com.jayway.jsonpath.JsonPath;
import com.mercadolibre.java_applications.dtos.response.ResponseDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content; // Add this import statement
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status; // Add this import statement
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get; // Add this import statement
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print; // Add this import statement

@AutoConfigureMockMvc
class PingControllerTest extends ControllerTest {

  @Autowired
  MockMvc mockMvc;

  @Test
  void ping() throws Exception {
    mockMvc.perform(get("/ping"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().json("{\"message\":\"pong\"}")).andReturn();
  }
}
