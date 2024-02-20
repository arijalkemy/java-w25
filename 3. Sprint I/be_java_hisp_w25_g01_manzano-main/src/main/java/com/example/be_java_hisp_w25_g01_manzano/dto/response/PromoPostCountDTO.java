package com.example.be_java_hisp_w25_g01_manzano.dto.response;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PromoPostCountDTO {
    Integer user_id;
    String user_name;
    Integer promo_products_count;
}

