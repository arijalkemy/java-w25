package org.socialmeli.dto.response.post;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PromoPostCountDto {
    Integer userId;
    String userName;
    Long promoProductsCount;
}
