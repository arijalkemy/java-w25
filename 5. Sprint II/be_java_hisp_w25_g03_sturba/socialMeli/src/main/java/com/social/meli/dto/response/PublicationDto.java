package com.social.meli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;


import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class PublicationDto {
    @JsonProperty("user_id")
    Integer userId;
    @JsonProperty("posts")
    List<@Valid PostDto> postDTOList;
}
