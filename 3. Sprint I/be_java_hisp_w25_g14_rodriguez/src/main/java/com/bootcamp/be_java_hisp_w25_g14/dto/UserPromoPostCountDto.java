package com.bootcamp.be_java_hisp_w25_g14.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

/**
 * Nueva clase definida para que sea el body del response al punto US0011
 * el cual nos permite saber la cantidad de post con descuento que tiene un usuario
 */
public class UserPromoPostCountDto {
    Integer user_id;
    String user_name;
    Integer promo_products_count;
}
