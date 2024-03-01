package com.bootcamp.be_java_hisp_w25_g9.dto.response;

import java.time.LocalDate;
import com.bootcamp.be_java_hisp_w25_g9.model.Product;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class PostResponseDtoMixin {
    @JsonProperty("post_id")
    private Integer id;

    @JsonProperty("user_id")
    private Integer userId;

    @JsonProperty("date")
    private LocalDate date;

    @JsonProperty("product")
    private Product product;

    @JsonProperty("category")
    private Integer category;

    @JsonProperty("price")
    private Double price;

}
