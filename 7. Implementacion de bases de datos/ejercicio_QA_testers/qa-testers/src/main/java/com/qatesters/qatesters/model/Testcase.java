package com.qatesters.qatesters.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name="TestCases")
public class Testcase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id_case")
    private Long idCase;

    private String description;

    private Boolean tested;

    private Boolean passed;

    @Column(name="number_of_tries")
    private Integer numberOfTries;

    @Column(name = "last_updated")
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate lastUpdated;
}
