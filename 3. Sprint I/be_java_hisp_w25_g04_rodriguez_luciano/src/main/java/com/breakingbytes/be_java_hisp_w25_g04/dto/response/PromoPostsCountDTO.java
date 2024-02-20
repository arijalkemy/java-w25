package com.breakingbytes.be_java_hisp_w25_g04.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PromoPostsCountDTO {
    int user_id;
    String user_name;
    int promo_products_count;
}
