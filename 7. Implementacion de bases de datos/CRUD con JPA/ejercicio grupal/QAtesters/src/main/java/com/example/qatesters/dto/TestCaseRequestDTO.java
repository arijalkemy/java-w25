package com.example.qatesters.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE )
@Data
public class TestCaseRequestDTO {

  String description;
  Boolean tested;
  Boolean passed;
  Integer number_of_tries;
  LocalDate last_update;
}
