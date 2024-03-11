package com.bootcamp.joyeria.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class GenericResponseDTO<T> {
    T response;
}
