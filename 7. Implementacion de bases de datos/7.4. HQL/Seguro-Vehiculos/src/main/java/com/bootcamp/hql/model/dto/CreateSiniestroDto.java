package com.bootcamp.hql.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateSiniestroDto {
    @JsonFormat(pattern = "yyyy/MM/dd")
    LocalDate fecha;
    @JsonProperty("perdida_economica")
    Double perdidaEconomica;
}
