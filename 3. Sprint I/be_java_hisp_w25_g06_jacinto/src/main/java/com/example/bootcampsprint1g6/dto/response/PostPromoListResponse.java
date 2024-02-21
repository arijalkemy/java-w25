package com.example.bootcampsprint1g6.dto.response;

import com.example.bootcampsprint1g6.entity.PostPromo;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class PostPromoListResponse {

    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("user_name")
    private String userName;
    private List<PostPromoResponseDTO> posts;

}
