package com.bootcamp.be_java_hisp_w25_g9.dto.request;

import com.bootcamp.be_java_hisp_w25_g9.dto.ProductDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public record PromoPostDto(
        @JsonProperty("post_id")
        int id,
        @JsonProperty("user_id")
        int userId,
        @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
        LocalDate date,
        ProductDto product,
        int category,
        double price,
        @JsonProperty("has_promo")
        boolean hasPromo,
        @JsonProperty("discount")
        double discount
){}
