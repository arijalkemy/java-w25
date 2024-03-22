package com.integrationelastic.exercise.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeDto {
    String name;
    String lastName;
    Integer age;
    String country;
    @JsonFormat(pattern = "dd/MM/yyy")
    LocalDate dateOfBirth;
}
