package com.meli.qatesters.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_case")
    private Long idCase;
    private String description;
    private Boolean tested;
    private Boolean passed;
    @Column(name = "number_of_tries")
    private int numberOfTries;
    @Column(name = "last_update")
    private LocalDate lastUpdate;
}
