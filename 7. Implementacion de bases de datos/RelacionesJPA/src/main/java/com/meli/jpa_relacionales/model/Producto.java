package com.meli.jpa_relacionales.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import java.util.Set;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long idProducto;
    private Long codigo;
    private String nombre;
    private Long precio;
    private Integer cantidad;

    @ManyToMany(mappedBy = "productos")
    private Set<Compra> compras;


}
