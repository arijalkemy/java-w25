package com.example.hqlsegurosvehiculos.dto.request;

import com.example.hqlsegurosvehiculos.entity.Siniestro;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NuevoVehiculoDTO {
    String patente;
    String marca;
    String modelo;
    Integer yaerFabricacion;
    Integer cantRuedas;
    Set<Siniestro> siniestros;
}