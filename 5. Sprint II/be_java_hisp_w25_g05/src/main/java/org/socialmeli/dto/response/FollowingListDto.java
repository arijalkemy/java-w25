package org.socialmeli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class FollowingListDto {
    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("user_name")
    private String userName;
    private List<UserDto> vendors;

    public FollowingListDto(Integer userId, String userName, List<UserDto> vendors) {
        this.userId = userId;
        this.userName = userName;
        this.vendors = vendors;
    }
}
