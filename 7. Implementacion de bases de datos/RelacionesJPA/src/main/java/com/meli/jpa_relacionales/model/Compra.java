package com.meli.jpa_relacionales.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compra")
    private Long idCompra;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @ManyToMany
    @JoinTable(
            name = "compras_productos",
            joinColumns = @JoinColumn(name = "id_compra"),
            inverseJoinColumns = @JoinColumn(name = "id_producto")
    )
    private Set<Producto> productos;

}
