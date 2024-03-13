package com.implementacionbd.ejercicio.dto.req;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeReqDTO {
    String name;

    @JsonProperty("last_name")
    String lastName;

    Integer age;

    CityReqDTO city;
}
