package org.socialmeli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PostIdDto {
    @JsonProperty("post_id")
    private Integer postId;

    public PostIdDto(Integer postId) {
        this.postId = postId;
    }
}
