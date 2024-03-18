package org.example.prendas.dto;

import jakarta.persistence.OneToMany;
import org.example.prendas.entity.Prenda;

import java.util.Date;
import java.util.Set;

public record SaleDTO(
        Long number,
        Date date,
        Double total,
        String payment,
        Set<Prenda>prendas
) {
}
