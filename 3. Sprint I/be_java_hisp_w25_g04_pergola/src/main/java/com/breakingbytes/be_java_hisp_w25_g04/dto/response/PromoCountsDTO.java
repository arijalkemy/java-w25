package com.breakingbytes.be_java_hisp_w25_g04.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromoCountsDTO {
    int user_id;
    String user_name;
    int promo_products_count;
}
