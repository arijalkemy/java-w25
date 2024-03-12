package com.mercadolibre.testerapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "test_case")
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_case")
    private Long idCase;

    private String description;
    private Boolean tested;
    private Boolean passed;

    @Column(name = "number_of_tries")
    private Integer numbreOfTries;
    @Column(name = "last_update")
    private LocalDate lastUpdate;

}
