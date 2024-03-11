package com.example.qatesters.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE )
public class TestCaseDTO {
  Long id_case;
  String description;
  Boolean tested;
  Boolean passed;
  Integer number_of_tries;
  LocalDate last_update;
}
