package com.grupo08.socialmeli.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductPromoCountDto {
    private int user_id;
    private String user_name;
    private long promo_products_count;
}
