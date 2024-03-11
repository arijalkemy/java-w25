package com.example.qa_testers.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_case")
    Long idCase;
    String description;
    @Column(nullable = false)
    Boolean tested;
    @Column(nullable = false)
    Boolean passed;
    @Column(name = "number_of_tries", nullable = false)
    Integer numberOfTries;
    @Column(name = "last_update")
    LocalDate lastUpdate;
}