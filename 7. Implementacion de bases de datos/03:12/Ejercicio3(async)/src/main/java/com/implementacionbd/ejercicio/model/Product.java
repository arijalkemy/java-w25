package com.implementacionbd.ejercicio.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Document(indexName = "products")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {

    public Product(String name, Integer amount, Double costPrice, Double salePrice) {
        this.name = name;
        this.amount = amount;
        this.costPrice = costPrice;
        this.salePrice = salePrice;
    }

    @Id
    @Field(name = "id")
    String id;

    @Field(name = "name")
    String name;

    @Field(name = "amount")
    Integer amount;

    @Field(name = "cost_price")
    Double costPrice;

    @Field(name = "sale_price")
    Double salePrice;

}
