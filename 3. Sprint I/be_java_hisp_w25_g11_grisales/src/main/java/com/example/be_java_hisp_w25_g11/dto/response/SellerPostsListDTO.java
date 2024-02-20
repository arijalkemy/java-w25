package com.example.be_java_hisp_w25_g11.dto.response;

import com.example.be_java_hisp_w25_g11.dto.SellerPostDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellerPostsListDTO {
    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("posts")
    private List<SellerPostDTO> posts;
}
