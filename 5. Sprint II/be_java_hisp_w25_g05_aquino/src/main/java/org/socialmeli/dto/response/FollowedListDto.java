package org.socialmeli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class FollowedListDto {
    @JsonProperty("user_id")
    private Integer userId;
    private List<PostDto> posts;

    public FollowedListDto(Integer userId, List<PostDto> posts) {
        this.userId = userId;
        this.posts = posts;
    }
}