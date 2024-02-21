package com.grupo08.socialmeli.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PromoPostCountDTO {
    private int user_id;
    private String user_name;
    private int promo_products_count;
}
