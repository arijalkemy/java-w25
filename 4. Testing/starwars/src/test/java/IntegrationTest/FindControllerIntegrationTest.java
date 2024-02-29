package IntegrationTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FindControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void findOkIntegrationTest() throws Exception {
        //Arrange

        //Act
        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/{query}","Luke"))
                .andDo(print())
                .andExpect(status().isOk());
                //.andExpect(content().contentType("application/json"));

        //Asert

    }
}
