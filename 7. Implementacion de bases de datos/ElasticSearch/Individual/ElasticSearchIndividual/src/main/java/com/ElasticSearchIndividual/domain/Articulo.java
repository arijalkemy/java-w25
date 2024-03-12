package com.ElasticSearchIndividual.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "blog")
@Data
public class Articulo {
    @Id
    private String id;
    private String titulo;
    @Field(type = FieldType.Nested, includeInParent = true)
    private List<Autor> autores;
}
