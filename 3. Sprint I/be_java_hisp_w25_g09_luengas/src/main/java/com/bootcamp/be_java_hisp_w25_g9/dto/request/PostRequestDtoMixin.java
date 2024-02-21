package com.bootcamp.be_java_hisp_w25_g9.dto.request;

import java.time.LocalDate;
import com.bootcamp.be_java_hisp_w25_g9.model.Product;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class PostRequestDtoMixin {
    @JsonProperty("user_id")
    private int userId;

    @JsonProperty("post_id")
    private int id;
    @JsonProperty("date")
    private LocalDate date;

    @JsonProperty("product")
    private Product product;

    @JsonProperty("category")
    private int category;

    @JsonProperty("price")
    private double price;
    
    @JsonProperty("has_promo")
    private boolean hasPromo;
    
    @JsonProperty("discount")
    private double discount;
}
