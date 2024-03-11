package com.joyeriaLaPerla.joyeriaLaPerla.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Jewerly {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long nro_id;
    private String name;
    private String material;
    private  double weight;
    private String particularity;
    private boolean hasStone;
    private boolean availableForSale;

    public Jewerly(String name, String material, double weight, String particularity, boolean hasStone, boolean availableForSale) {
        this.name = name;
        this.material = material;
        this.weight = weight;
        this.particularity = particularity;
        this.hasStone = hasStone;
        this.availableForSale = availableForSale;
    }
}
