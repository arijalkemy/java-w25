package com.example.be_java_hisp_w25_g10.dtos.promos;

import com.example.be_java_hisp_w25_g10.entities.Product;

public record PromoDto (int user_id,
                        String date,
                        PromoProductDto product,
                        int category,
                        double price,
                        boolean has_promo,
                        double discount){
}
