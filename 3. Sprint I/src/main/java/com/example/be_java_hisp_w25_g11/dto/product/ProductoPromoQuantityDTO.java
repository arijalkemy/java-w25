package com.example.be_java_hisp_w25_g11.dto.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoPromoQuantityDTO {
    @JsonProperty("user_id")
    private  int userId;
    @JsonProperty("user_name")
    private String  userName;
    @JsonProperty("promo_products_count")
    private long promoProductsCount;
}
