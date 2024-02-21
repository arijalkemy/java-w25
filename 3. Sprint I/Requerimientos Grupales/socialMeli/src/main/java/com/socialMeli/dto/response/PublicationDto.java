package com.socialMeli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.socialMeli.dto.request.PostDTO;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class PublicationDto {
    @JsonProperty("user_id")
    Integer userId;
    @JsonProperty("posts")
    List<PostDto> postDTOList;
}
