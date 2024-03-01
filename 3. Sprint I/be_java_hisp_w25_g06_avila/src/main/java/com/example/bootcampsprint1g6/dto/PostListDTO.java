package com.example.bootcampsprint1g6.dto;

import com.example.bootcampsprint1g6.dto.response.PostResponseDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PostListDTO {

    @JsonProperty("user_id")
    private Integer userId;
    private List<PostResponseDTO> posts;

}
