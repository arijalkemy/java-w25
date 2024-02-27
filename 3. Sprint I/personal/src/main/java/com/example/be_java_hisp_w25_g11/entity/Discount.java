package com.example.be_java_hisp_w25_g11.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Discount {
    private int userId;
    private int productId;
    private int postId;
    private boolean hasPromo;
    private float discount;
}
