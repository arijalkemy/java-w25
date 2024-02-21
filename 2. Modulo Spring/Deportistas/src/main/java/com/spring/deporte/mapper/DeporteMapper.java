package com.spring.deporte.mapper;

import com.spring.deporte.domain.Deporte;
import com.spring.deporte.dto.DeporteDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DeporteMapper {
    public static DeporteDTO getInstance(Deporte deporte) {
        DeporteDTO dto = DeporteDTO.builder()
                .nombre(deporte.getNombre())
                .nivel(deporte.getNivel())
                .build();

        return dto;
    }

    public static List<DeporteDTO> getInstances(List<Deporte> deportes) {
        return deportes.stream().map(DeporteMapper::getInstance).collect(Collectors.toList());
    }
}
