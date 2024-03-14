package com.mercadolibre.elasticsearch_vivo.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "literary_works")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LiteraryWork {
    @Id
    String id;
    String name;
    String author;
    Integer pageCount;
    String editorial;
    Integer firstPublishingYear;
}
