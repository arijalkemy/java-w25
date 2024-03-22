package com.example.ejercicio_deportistas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PersonDTO {
    @JsonProperty("name")
    String name;
    @JsonProperty("last_name")
    String lastName;
    @JsonProperty("age")
    Integer age;
}
