package org.socialmeli.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.socialmeli.entity.User;
import org.socialmeli.entity.Vendor;
import org.socialmeli.util.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UsersControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectFactory objectFactory = new ObjectFactory();

    @BeforeAll
    public static void setUp() {
        User.userIdCounter = 0;
    }

    @Test
    void followerCountOfAVendorWithNoFollowers() throws Exception {

        Vendor vendor = objectFactory.getValidRepoVendor();

        Integer expectedFollowerCount = vendor.getFollowers().size();

        mockMvc.perform(get("/users/{userId}/followers/count", vendor
                                .getUserId()))
                        .andDo(print())
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.user_id").value(vendor.getUserId()))
                        .andExpect(jsonPath("$.user_name").value(vendor.getUserName()))
                        .andExpect(jsonPath("followers_count").value(expectedFollowerCount))
                        .andReturn();
    }

    @Test
    void cantGetAFollowerCountOfAnNoneExistentVendor() throws Exception {
        Integer nonExistentVendorId = objectFactory.getInvalidUserId();

        MvcResult result =
                mockMvc.perform(get("/users/{userId}/followers/count", nonExistentVendorId))
                        .andDo(print())
                        .andExpect(status().isNotFound())
                        .andExpect(jsonPath("$.message").value("El vendedor no existe"))
                        .andReturn();
    }
}
