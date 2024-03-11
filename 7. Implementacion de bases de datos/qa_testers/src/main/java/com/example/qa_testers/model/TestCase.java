package com.example.qa_testers.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "test_cases")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_case;
    @Column
    private String description;
    @Column
    private Boolean tested;
    @Column
    private Boolean passed;
    @Column
    private Integer number_of_tries;
    @Column
    private LocalDate last_update;

    public TestCase(String description, Boolean tested, Boolean passed, Integer number_of_tries, LocalDate last_update) {
        this.description = description;
        this.tested = tested;
        this.passed = passed;
        this.number_of_tries = number_of_tries;
        this.last_update = last_update;
    }
}
