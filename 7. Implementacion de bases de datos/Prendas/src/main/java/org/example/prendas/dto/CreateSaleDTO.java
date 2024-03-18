package org.example.prendas.dto;

import jakarta.persistence.OneToMany;
import org.example.prendas.entity.Prenda;

import java.util.Date;
import java.util.List;
import java.util.Set;

public record CreateSaleDTO(
        Double total,
        String payment,
        List<Long> prendas
) {

}
