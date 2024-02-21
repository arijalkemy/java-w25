package com.example.be_java_hisp_w25_g11_grisales.dto.response;

import com.example.be_java_hisp_w25_g11_grisales.dto.SellerPromoPostDTO;
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
    private Integer userId;
    @JsonProperty("user_name")
    private String userName;
    @JsonProperty("posts")
    private List<SellerPromoPostDTO> posts;
}
