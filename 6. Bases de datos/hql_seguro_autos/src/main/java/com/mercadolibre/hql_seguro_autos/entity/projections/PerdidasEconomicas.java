package com.mercadolibre.hql_seguro_autos.entity.projections;

import com.fasterxml.jackson.annotation.JsonProperty;


public interface PerdidasEconomicas {
    String getPatente();
    String getMarca();
    String getModelo();
    @JsonProperty("perdida_total")
    Double getPerdidaTotal();
}
