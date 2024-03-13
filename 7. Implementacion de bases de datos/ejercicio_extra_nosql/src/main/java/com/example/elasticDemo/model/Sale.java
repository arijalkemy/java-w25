package com.example.elasticDemo.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;
import java.util.List;

@Document(indexName = "sales")
@Getter @Setter
public class Sale {
    @Id
    String id;
    @Field(type = FieldType.Date)
    LocalDate fecha;
    Double total;
    String medio_pago;
    @Field(type = FieldType.Nested, includeInParent = true) // ???
    List<Clothes> prendas;
}
