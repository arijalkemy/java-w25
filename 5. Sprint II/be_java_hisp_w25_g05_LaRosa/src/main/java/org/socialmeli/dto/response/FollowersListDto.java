package org.socialmeli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class FollowersListDto {
    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("user_name")
    private String userName;
    private List<UserDto> followers;

    public FollowersListDto(Integer userId, String userName, List<UserDto> followers) {
        this.userId = userId;
        this.userName = userName;
        this.followers = followers;
    }
}
