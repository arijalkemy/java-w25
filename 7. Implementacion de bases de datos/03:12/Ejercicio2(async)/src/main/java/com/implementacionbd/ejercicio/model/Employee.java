package com.implementacionbd.ejercicio.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Document(indexName = "employees")
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employee {

    public Employee(String name, String lastName, Integer age, City city) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.city = city;
    }

    @Id
    String id;

    String name;

    @Field(name = "last_name")
    String lastName;

    Integer age;

    @Field(type = FieldType.Nested, includeInParent = true)
    City city;
}
