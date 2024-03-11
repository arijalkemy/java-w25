package com.implementacionbasedatos.ejercicio1.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "test_case")
public class TestCase {
    @Id
    @Column(name = "id_case")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCase;

    private String description;

    private Boolean tested;

    private Boolean passed;

    @Column(name = "number_of_tries")
    private Integer numberOfTries;

    @Column(name = "last_update")
    private LocalDate lastUpdate;
}
