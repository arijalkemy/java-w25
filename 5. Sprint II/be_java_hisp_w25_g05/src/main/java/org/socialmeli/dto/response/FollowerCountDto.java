package org.socialmeli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class FollowerCountDto {
    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("user_name")
    private String userName;
    @JsonProperty("followers_count")
    private Integer followersCount;

    public FollowerCountDto(Integer userId, String userName, Integer followersCount) {
        this.userId = userId;
        this.userName = userName;
        this.followersCount = followersCount;
    }
}
