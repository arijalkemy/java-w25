package com.mercadolibre.elastic.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
@Getter
@Setter
@Document(indexName = "employees")
public class Employee {
    @Id
    private Integer id;
    private String name;
    private String lastName;
    private Integer age;
    private String city;
    private String state;
}
