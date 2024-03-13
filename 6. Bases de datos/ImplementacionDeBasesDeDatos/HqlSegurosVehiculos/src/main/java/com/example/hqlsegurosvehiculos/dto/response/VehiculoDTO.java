package com.example.hqlsegurosvehiculos.dto.response;

import com.example.hqlsegurosvehiculos.entity.Siniestro;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class VehiculoDTO {
    String patente;
    String marca;
    String modelo;
    Integer yearFabricacion;
    Integer cantRuedas;
    Set<Siniestro> siniestros;
}
