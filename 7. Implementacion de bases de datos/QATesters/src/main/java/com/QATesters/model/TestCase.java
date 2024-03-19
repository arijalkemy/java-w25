package com.QATesters.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
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
    private Integer numberOfTries;

    @Temporal(TemporalType.DATE)
    @LastModifiedDate
    @Column(name = "last_update")
    private LocalDate lastUpdate;

}
