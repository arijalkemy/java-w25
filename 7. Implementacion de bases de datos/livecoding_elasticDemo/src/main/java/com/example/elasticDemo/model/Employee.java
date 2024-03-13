package com.example.elasticDemo.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.stereotype.Indexed;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Document(indexName = "Employees")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Employee {
    @Id
    String id;
    String name;
    String lastname;
    Integer age;
    String country;
    @Field(type = FieldType.Date) // Asi se transforma para elastic
    LocalDate dateOfBirth;


}
