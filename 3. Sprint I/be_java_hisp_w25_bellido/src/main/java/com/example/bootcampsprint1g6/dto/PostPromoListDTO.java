package com.example.bootcampsprint1g6.dto;

import com.example.bootcampsprint1g6.dto.response.PostPromoResponseDTO;
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
public class PostPromoListDTO {

    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("user_name")
    private String usernName;
    private List<PostPromoResponseDTO> posts;

}
