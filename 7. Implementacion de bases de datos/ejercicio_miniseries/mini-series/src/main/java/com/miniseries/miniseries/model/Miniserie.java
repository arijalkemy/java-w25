package com.miniseries.miniseries.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Miniseries")
public class Miniserie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "miniserie_id")
    private Long id;

    private String name;
    private Double rating;

    @Column(name = "amount_of_awards")
    private Integer amountOfAwards;
}
