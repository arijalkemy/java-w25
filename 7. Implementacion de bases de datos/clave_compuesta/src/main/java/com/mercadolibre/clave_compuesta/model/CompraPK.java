package com.mercadolibre.clave_compuesta.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class CompraPK implements Serializable {
    Long clienteId;
    LocalDate fecha;
}
