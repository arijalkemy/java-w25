package org.example.prendas.entity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
@Data
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long number;
    private LocalDate date;
    private Double total;
    private String payment;
    @OneToMany
    private Set<Prenda> prendas;


}
