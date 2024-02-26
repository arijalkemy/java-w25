package com.mercadolibre.starwars.integration;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class FindControllerIT {

    @Autowired
    MockMvc mockMvc;

    static ObjectWriter writer;

    @BeforeAll
    static void setup() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();
    }

    @Test
    @DisplayName("Get characters containing 'Luke' (IT) - Success")
    public void getCharacterByName() throws Exception {
        this.mockMvc.perform(get("/Luke"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(content().json("[{\"name\":\"Luke Skywalker\",\"hair_color\":\"blond\",\"skin_color\":\"fair\",\"eye_color\":\"blue\",\"birth_year\":\"19BBY\",\"gender\":\"male\",\"homeworld\":\"Tatooine\",\"species\":\"Human\",\"height\":172,\"mass\":77}]"))
        ;
    }
    @Test
    @DisplayName("Get characters containing 'Darth' (IT) - Success")
    public void getCharactersByName() throws Exception {
        this.mockMvc.perform(get("/Darth"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(content().json("[{\"name\":\"Darth Vader\",\"hair_color\":\"none\",\"skin_color\":\"white\",\"eye_color\":\"yellow\",\"birth_year\":\"41.9BBY\",\"gender\":\"male\",\"homeworld\":\"Tatooine\",\"species\":\"Human\",\"height\":202,\"mass\":136},{\"name\":\"Darth Maul\",\"hair_color\":\"none\",\"skin_color\":\"red\",\"eye_color\":\"yellow\",\"birth_year\":\"54BBY\",\"gender\":\"male\",\"homeworld\":\"Dathomir\",\"species\":\"Zabrak\",\"height\":175,\"mass\":80}]"));
    }
    @Test
    @DisplayName("Get characters containing 'Java' (IT) - Error")
    public void getCharactersByNameError() throws Exception {
        this.mockMvc.perform(get("/Java"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.length()").value(0));
    }

}
