package com.breakingbytes.be_java_hisp_w25_g04_gutierrez.dto.request;

import com.breakingbytes.be_java_hisp_w25_g04_gutierrez.entity.Product;
import com.breakingbytes.be_java_hisp_w25_g04_gutierrez.utils.LocalDateDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PostDTO {
    @JsonProperty("user_id")
    int userId;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    LocalDate date;
    Product product;
    int category;
    double price, discount;
    @JsonProperty("has_promo")
    boolean hasPromo;
}
