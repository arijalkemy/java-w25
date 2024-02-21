package org.socialmeli.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PromoCountDto {
    Integer user_id;
    String user_name;
    Integer promo_products_count;

    public PromoCountDto(Integer user_id) {
        this.user_id = user_id;
    }
}
