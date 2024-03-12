package com.mercadolibre.testerapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tester")
public class Tester {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_case")
    private Long idTester;

    private String nombre;
    private String apellido;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idTester")
    private List<TestCase> listTests;



}
