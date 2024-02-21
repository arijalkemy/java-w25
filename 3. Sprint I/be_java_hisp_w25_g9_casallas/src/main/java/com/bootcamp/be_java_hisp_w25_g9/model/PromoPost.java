package com.bootcamp.be_java_hisp_w25_g9.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PromoPost extends Post{

    private boolean promo;
    private double discount;
}
