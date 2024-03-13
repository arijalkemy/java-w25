package com.bootcamp.hql.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkSiniestroDto {
    @JsonProperty("id_siniestro")
    private Long idSiniestro;
    @JsonProperty("id_vehiculo")
    private Long idVehiculo;
}
