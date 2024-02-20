package com.example.be_java_hisp_w25_g01.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PromoNewPriceDTO {
    //US 0002
    String userName;
    String product_name;
    Double original_price;
    Double discount;
    Double promo_price;

}
