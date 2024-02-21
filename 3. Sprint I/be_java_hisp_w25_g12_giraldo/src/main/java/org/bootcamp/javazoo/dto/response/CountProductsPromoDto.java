package org.bootcamp.javazoo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CountProductsPromoDto {

    private int user_id;
    private String user_name;
    private int promo_products_count;

}
