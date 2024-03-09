package com.bootcamp.ejercicio_mini_series.util;

import com.bootcamp.ejercicio_mini_series.dto.request.MiniserieRequestDTO;
import com.bootcamp.ejercicio_mini_series.dto.response.MiniserieResponseDTO;
import com.bootcamp.ejercicio_mini_series.model.MiniSerie;

public class Mapper {
    public static MiniserieResponseDTO getResponse(MiniSerie miniserie) {
        return MiniserieResponseDTO.builder()
                .id(miniserie.getId())
                .name(miniserie.getName())
                .rating(miniserie.getRating())
                .amountOfAwards(miniserie.getAmountOfAwards())
                .build();
    }

    public static MiniSerie getEntity(MiniserieRequestDTO dto) {
        return MiniSerie.builder()
                .name(dto.getName())
                .rating(dto.getRating())
                .amountOfAwards(dto.getAmountOfAwards())
                .build();
    }
}
