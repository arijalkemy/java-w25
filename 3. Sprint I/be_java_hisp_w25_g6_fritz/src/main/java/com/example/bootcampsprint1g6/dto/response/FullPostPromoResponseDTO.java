package com.example.bootcampsprint1g6.dto.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FullPostPromoResponseDTO {
    @JsonProperty("user_id")
    private Integer id;
    @JsonProperty("user_name")
    private String userName;
    private List<PostPromoResponseDTO> posts;
}
