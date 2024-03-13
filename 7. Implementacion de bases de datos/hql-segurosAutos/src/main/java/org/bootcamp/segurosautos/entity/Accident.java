package org.bootcamp.segurosautos.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Accident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private Double cost;
    @ManyToOne
    @JoinColumn(name = "vehicle_id", referencedColumnName = "id",nullable = false)
    private Vehicle vehicle;

}
