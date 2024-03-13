package com.example.elasticDemo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDTO {

    String id;
    String name;
    String lastname;
    Integer age;
    String country;
    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate dateOfBirth;
    // shape = JsonFormat.Shape.STRING --> nO ES NECESARIO, PREGUNTAR PARA QUE ES
}
