package com.numeros.romanos.dto.mapper;


import com.numeros.romanos.domain.Numero;
import com.numeros.romanos.dto.response.NumeroResponseDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class NumeroMapper {

    public static NumeroResponseDTO getInstance(Numero numero) {
        NumeroResponseDTO dto = NumeroResponseDTO.builder()
                .id(numero.getId())
                .valorRomano(numero.getValorRomano())
                .build();

        return dto;
    }

    public static List<NumeroResponseDTO> getInstance(List<Numero> numeros) {
        return numeros.stream().map(NumeroMapper::getInstance).collect(Collectors.toList());
    }
}
