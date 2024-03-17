package com.meli.showroom.dto;

import com.meli.showroom.entity.Prenda;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class VentaDTO {
    Long numero;
    LocalDate fecha;
    Double total;
    String medioPago;
    Set<PrendaDTO> listPrendas;

}
