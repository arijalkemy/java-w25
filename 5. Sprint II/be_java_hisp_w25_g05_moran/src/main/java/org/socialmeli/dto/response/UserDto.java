package org.socialmeli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserDto {
    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("user_name")
    private String userName;

    public UserDto(Integer userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }
}
