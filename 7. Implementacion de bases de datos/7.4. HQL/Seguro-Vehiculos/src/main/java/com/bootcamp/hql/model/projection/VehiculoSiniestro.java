package com.bootcamp.hql.model.projection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoSiniestro {
    List<SelectByPerdidaEconomica> vehiculos;
    Double perdidaTotal;
}