package com.example.bootcampsprint1g6.integration;

import com.example.bootcampsprint1g6.dto.request.PostRequestDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static com.example.bootcampsprint1g6.util.builder.Mockbuilder.buildPostNoProductRequestDTO;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ExceptionIT {
    @Autowired
    MockMvc mockMvc;

    static ObjectWriter writer;

    @BeforeAll
    static void setup() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
    }

    @Test
    @DisplayName("Method error (IT) - Error")
    void methodError() throws Exception {
        mockMvc.perform(get("/api/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(""))
                .andExpect(status().isMethodNotAllowed())
                .andExpect(jsonPath("$.message").value("Metodo no soportado"));
    }

    @Test
    @DisplayName("NullPointerException (IT) - Error")
    void nullPointerExceptionError() throws Exception {
        PostRequestDTO postDTO = buildPostNoProductRequestDTO();
        String payloadJson = writer.writeValueAsString(postDTO);
        mockMvc.perform(post("/api/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Atributos faltantes, por favor verifique la información enviada."));
    }

    @Test
    @DisplayName("MethodArgumentTypeMismatch (IT) - Error")
    public void methodArgumentTypeMismatchError() throws Exception {
        this.mockMvc.perform(post("/api/users/{userId}/follow/{userIdToFollow}", "1","fdfdfd"))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("Error en el tipo de datos de los parámetros"));
    }

}
