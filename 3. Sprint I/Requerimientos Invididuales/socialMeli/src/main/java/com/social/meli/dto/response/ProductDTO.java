package com.social.meli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;


public record ProductDTO(@JsonProperty("product_id")
                         Integer productId,
                         @JsonProperty("product_name")
                         String productName,
                         @JsonProperty("type")
                         String type,
                         @JsonProperty("brand")
                         String brand,
                         @JsonProperty("color")
                         String color,
                         @JsonProperty("notes")
                         String notes) {

}
