package com.clave.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@IdClass(CompraKey.class)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="compras")
public class Compra {
    @Id
    private Long clienteId;
    @Id
    private LocalDate fecha;
    private String descripcion;
}


