package com.meli.seguros.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class VehiculoSiniestroDTO {
    List<PatenteMarcaModeloDto> vehiculos;
    Double perdidaTotal;

    public VehiculoSiniestroDTO() {
        this.vehiculos = new ArrayList<>();
        this.perdidaTotal = 0.0;
    }
}
