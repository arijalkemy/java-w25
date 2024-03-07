package com.bootcamp.Calorias.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestPlatosDTO {
    private List<RequestCaloriasDTO> listaPlatos;
}
