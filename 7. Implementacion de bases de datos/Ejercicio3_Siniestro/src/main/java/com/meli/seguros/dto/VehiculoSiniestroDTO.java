package com.meli.seguros.dto;

import com.meli.seguros.model.Vehiculo;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class VehiculoSiniestroDTO {
    Vehiculo vehiculo;
    Double perdidaTotal;
}
