package com.grupo08.socialmeli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.grupo08.socialmeli.dto.PostDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FollowingPostDto {
    @JsonProperty("user_id")
    //@NotBlank(message = "El id no puede estar vacio.")
    @Positive(message = "El id debe ser mayor a 0.")
    private Integer userId;
    private List<PostDto> post;
}
