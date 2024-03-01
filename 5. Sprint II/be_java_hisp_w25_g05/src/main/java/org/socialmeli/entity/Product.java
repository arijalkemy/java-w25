package org.socialmeli.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Product {
    @JsonProperty("product_id")
    private Integer productId;
    @JsonProperty("product_name")
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;

    public Product() {
        this.productId = null;
        this.productName = null;
        this.type = null;
        this.brand = null;
        this.color = null;
        this.notes = null;
    }

    public Product(Integer productId, String productName, String type, String brand, String color, String notes) {
        this.productId = productId;
        this.productName = productName;
        this.type = type;
        this.brand = brand;
        this.color = color;
        this.notes = notes;
    }
}
