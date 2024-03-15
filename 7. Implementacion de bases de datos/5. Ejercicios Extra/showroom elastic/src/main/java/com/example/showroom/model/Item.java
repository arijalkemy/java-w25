package com.example.showroom.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.annotation.Id;


@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "items")
public class Item {
    @Id
    String id;
    Integer quantity;
    String saleId;
    Clothe clothe;
}
