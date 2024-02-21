package org.socialmeli.dto.response;

import lombok.Data;

@Data
public class VendorPromoPostCounterDto {
    private Integer userId;
    private String userName;
    private Integer promoProductsCount;

    public VendorPromoPostCounterDto() {}

    public VendorPromoPostCounterDto(Integer userId, String userName, Integer promoProductsCount) {
        this.userId = userId;
        this.userName = userName;
        this.promoProductsCount = promoProductsCount;
    }
}
