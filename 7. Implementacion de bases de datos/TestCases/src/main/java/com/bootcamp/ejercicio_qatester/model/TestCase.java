package com.bootcamp.ejercicio_qatester.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

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
    @ManyToMany
    @JoinTable(
            name = "test_tester",
            joinColumns =  @JoinColumn(name = "test_id"),
            inverseJoinColumns = @JoinColumn(name = "tester_id")
    )
    Set<Tester> testers;
    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    Project project;
}
