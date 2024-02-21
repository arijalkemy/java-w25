package com.grupo08.socialmeli.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PromoPostxSellerDto {
    int user_id;
    String user_name;
    int promo_products_count;
}
