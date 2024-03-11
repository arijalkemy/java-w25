package com.crud.crud_con_jpa.dto;

public record JewelDTO (
        Long id,
        String name,
        String material,
        Double weight,
        String particularidad,
        Boolean hasStone,
        Boolean forSale
) {
}
