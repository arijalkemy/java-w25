package com.bootcamp.ejercicio_mini_series.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MiniserieResponseDTO {
    private Long id;
    private String name;
    private Double rating;
    private int amountOfAwards;
}
