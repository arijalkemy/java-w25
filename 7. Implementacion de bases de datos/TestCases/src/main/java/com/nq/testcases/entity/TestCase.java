package com.nq.testcases.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id_case")
    private Long idCase;
    private String description;
    private Boolean tested;
    private Boolean passed;
    @JsonProperty("number_of_tries")
    private Integer numberOfTries;
    @JsonProperty("last_update")
    private LocalDate lastUpdate;

    @PrePersist
    @PreUpdate
    public void updateLastUpdate() {
        this.lastUpdate = LocalDate.now();
    }
}
