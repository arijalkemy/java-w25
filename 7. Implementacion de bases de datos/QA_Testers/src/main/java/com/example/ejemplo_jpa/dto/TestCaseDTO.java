package com.example.ejemplo_jpa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestCaseDTO {
    Long id_case;
    String description;
    Boolean tested;
    Boolean passed;
    Integer number_of_tries;
    LocalDate last_update;
}


