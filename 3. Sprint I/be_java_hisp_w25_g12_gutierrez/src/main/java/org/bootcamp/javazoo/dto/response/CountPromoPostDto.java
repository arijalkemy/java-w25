package org.bootcamp.javazoo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CountPromoPostDto {
    private Integer user_id;
    private String user_name;
    private Integer promo_products_count;
}
