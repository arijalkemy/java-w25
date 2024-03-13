package org.bootcamp.elasticlivecoding.entity;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;
@Document(indexName = "employees")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employee {
    @Id
    Integer id;
    String name;
    String lastname;
    int age;
    String country;
    @Field(type = FieldType.Date)
    LocalDate dateOfBirth;

    public Employee(String name, String lastname, int age, String country, LocalDate dateOfBirth) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.country = country;
        this.dateOfBirth = dateOfBirth;
    }
}
