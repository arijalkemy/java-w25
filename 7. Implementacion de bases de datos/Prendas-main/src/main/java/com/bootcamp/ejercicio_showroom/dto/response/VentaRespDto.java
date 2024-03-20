package com.bootcamp.ejercicio_showroom.dto.response;

import com.bootcamp.ejercicio_showroom.dto.request.PrendaRequDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class VentaRespDto {
    Long numero;
    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate fecha;
    Integer total;
    String medio_de_pago;
    List<PrendaRequDto> prendas;
}
