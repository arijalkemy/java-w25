package com.bootcamp.be_java_hisp_w25_g14.dto;

public record SellerAvgPriceDto (
        Integer user_id,
        String user_name,
        Integer number_of_posts,
        Double avg_price
){
}
