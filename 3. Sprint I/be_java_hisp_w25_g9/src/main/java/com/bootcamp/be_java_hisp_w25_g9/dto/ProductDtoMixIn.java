package com.bootcamp.be_java_hisp_w25_g9.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class ProductDtoMixIn {
    @JsonProperty("product_id")
    private int productId;

    @JsonProperty("product_name")
    private String productName;

    @JsonProperty("type")
    private String type;

    @JsonProperty("brand")
    private String brand;

    @JsonProperty("color")
    private String color;

    @JsonProperty("notes")
    private String notes;
    }