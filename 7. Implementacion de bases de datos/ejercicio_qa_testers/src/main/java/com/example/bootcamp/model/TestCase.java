package com.example.bootcamp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id_case;
    String description;
    boolean tested;
    boolean passed;
    int number_of_tries;
    LocalDate last_update;
    boolean activo;
}
