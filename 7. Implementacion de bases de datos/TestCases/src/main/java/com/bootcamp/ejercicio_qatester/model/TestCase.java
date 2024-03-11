package com.bootcamp.ejercicio_qatester.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id_case;
    String description;
    Boolean tested;
    Boolean passed;
    Integer number_of_tries;
    @JsonFormat(pattern="dd/MM/yyyy")
    LocalDate last_update;
}
