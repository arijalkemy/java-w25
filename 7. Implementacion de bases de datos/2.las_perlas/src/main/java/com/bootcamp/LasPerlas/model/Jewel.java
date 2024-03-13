package com.bootcamp.LasPerlas.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Jewel {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @JsonProperty("number_identification")
    private Long numberIdentification;
    private String name;
    private String material;
    private Double weight;
    private String particularity;
    @JsonProperty("has_stone")
    private boolean hasStone;
    private boolean saleOrNot;

    public Jewel() {
    }

    public Jewel(String name, String material, Double weight, String particularity, boolean hasStone, boolean saleOrNot) {
        this.name = name;
        this.material = material;
        this.weight = weight;
        this.particularity = particularity;
        this.hasStone = hasStone;
        this.saleOrNot = saleOrNot;
    }
}
