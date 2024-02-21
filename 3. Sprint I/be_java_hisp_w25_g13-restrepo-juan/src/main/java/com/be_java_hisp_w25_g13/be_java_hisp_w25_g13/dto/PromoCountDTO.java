package com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PromoCountDTO {

    Integer userId;
    String userName;
    Integer promoProductsCount;
}
