package com.example.hqlsegurosvehiculos.dto.response;

import com.example.hqlsegurosvehiculos.entity.Vehiculo;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SiniestrosDTO {
    String fechaSiniestro;
    double perdida;
    Integer vehiculoId;
}
