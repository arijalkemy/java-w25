package com.relations.relations.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestCarritoDto {
    private Boolean lleno;
    private Set<RequestProductoDto> productos;
}
