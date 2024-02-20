package com.breakingbytes.be_java_hisp_w25_g04_gutierrez.dto.response;

import com.breakingbytes.be_java_hisp_w25_g04_gutierrez.dto.request.UserDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserFollowersDTO {
    @JsonProperty("user_id")
    int id;
    @JsonProperty("user_name")
    String name;
    List<UserDTO> followers;
}
