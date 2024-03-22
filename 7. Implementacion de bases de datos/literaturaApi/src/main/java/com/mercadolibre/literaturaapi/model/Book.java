package com.mercadolibre.literaturaapi.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(indexName = "literatura")
public class Book {
    @Id
    String id;

    String author;
    String title;
    Integer pages;
    @Field(name = "publish_year")
    Integer publishYear;
    String publisher;
}
