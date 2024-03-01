package com.bootcamp.be_java_hisp_w25_g02.dto.response;

import com.bootcamp.be_java_hisp_w25_g02.dto.request.PostDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record FollowingPostDTO(
    @NotNull(message = "El id producto no puede ser nulo")
    @Min(value = 1, message = "El id de usuario no puede ser menor a 1")
    @JsonProperty("user_id")
    Integer userId,
    @NotNull
    List<PostDTO> posts
) {
}
