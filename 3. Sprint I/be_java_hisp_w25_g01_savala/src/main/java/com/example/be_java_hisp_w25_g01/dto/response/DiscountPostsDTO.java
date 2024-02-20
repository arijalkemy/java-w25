package com.example.be_java_hisp_w25_g01.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DiscountPostsDTO {
    Integer user_id;
    String user_name;
    Integer promo_products_count;
}
