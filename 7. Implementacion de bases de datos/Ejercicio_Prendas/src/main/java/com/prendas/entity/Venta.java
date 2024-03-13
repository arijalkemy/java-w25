package com.prendas.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long numero;
    LocalDate fecha;
    Double total;
    String medioPago;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "venta_id")
    Set<Prenda> prendaList;
}
