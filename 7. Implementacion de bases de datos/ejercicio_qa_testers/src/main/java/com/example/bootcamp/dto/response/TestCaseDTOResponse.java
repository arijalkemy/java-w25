package com.example.bootcamp.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TestCaseDTOResponse {
    Long id_case;
    String description;
    boolean tested;
    boolean passed;
    int number_of_tries;
    LocalDate last_update;
}
