package com.breakingbytes.be_java_hisp_w25_g04.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CountPromoPostDTO {
    @JsonProperty("user_id")
    int id;
    @JsonProperty("user_name")
    String name;
    int promo_products_count;
}
