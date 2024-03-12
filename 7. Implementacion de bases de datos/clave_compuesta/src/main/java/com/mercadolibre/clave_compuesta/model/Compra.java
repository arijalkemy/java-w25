package com.mercadolibre.clave_compuesta.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "compras")
@Getter
@Setter
@NoArgsConstructor
@IdClass(value = CompraPK.class)
public class Compra {
    @Id
    Long clienteId;
    @Id
    LocalDate fecha;
    String descripcion;
}
