package com.breakingbytes.be_java_hisp_w25_g04_gutierrez.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;


@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PromoPostDTO {
    @JsonProperty("user_id")
    int userId;
    @JsonProperty("user_name")
    String userName;
    @JsonProperty("promo_products_count")
    int promoProductsCount;
}
