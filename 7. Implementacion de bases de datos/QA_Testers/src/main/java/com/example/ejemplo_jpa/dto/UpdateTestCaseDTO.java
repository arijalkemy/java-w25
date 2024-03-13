package com.example.ejemplo_jpa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTestCaseDTO {
    String description;
    Boolean tested;
    Boolean passed;
    Integer number_of_tries;
    LocalDate last_update;
}


