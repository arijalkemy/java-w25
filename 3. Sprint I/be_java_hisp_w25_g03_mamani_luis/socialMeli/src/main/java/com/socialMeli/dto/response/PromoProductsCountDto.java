package com.socialMeli.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PromoProductsCountDto {
    private Integer userId;
    private String userName;
    private int promoProductsCount;
}
