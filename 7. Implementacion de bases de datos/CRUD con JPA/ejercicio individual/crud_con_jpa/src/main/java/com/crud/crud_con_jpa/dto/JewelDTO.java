package com.crud.crud_con_jpa.dto;

public record JewelDTO (
        // Por motivos de tiempo no uso DTO en esta ejercitacion pero lo correcto sería usarlo.
        Long id,
        String name,
        String material,
        Double weight,
        String particularidad,
        Boolean hasStone,
        Boolean forSale
) {
}
