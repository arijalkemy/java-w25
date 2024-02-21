package com.social.meli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public record PublicationDto(@JsonProperty("user_id")
                             Integer userId,
                             @JsonProperty("posts")
                             List<PostDto> postDTOList) {

}
