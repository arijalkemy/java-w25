package com.example.be_java_hisp_w25_g11.dto.response;

import com.example.be_java_hisp_w25_g11.dto.SellerPostDTO;
import com.example.be_java_hisp_w25_g11.dto.SellerPromoPostDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellerPromoPostListDTO {
    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("user_name")
    private String name;
    @JsonProperty("posts")
    private List<SellerPromoPostDTO> posts;
}
