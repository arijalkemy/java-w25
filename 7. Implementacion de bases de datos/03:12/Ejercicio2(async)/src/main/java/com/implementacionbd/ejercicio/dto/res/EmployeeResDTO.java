package com.implementacionbd.ejercicio.dto.res;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeResDTO {
    String id;

    String name;

    @JsonProperty("last_name")
    String lastName;

    Integer age;

    CityResDTO city;
}
