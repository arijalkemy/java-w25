package com.integrationelastic.exercise.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;

@Data
@Document(indexName = "employees")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employee {
    @Id
    String id;
    String name;
    String lastName;
    Integer age;
    String country;
    @Field(type = FieldType.Date)
    LocalDate dateOfBirth;

    public Employee(String name, String lastName, Integer age, String country, LocalDate dateOfBirth) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.country = country;
        this.dateOfBirth = dateOfBirth;
    }
}
