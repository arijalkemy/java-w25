package com.meli.jpa_relacionales.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long idCliente;
    private Integer dni;
    private String nombre;
    private String apellido;
    private String telefono;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "direccion", referencedColumnName = "id_direccion")
    private Direccion direccion;

    @OneToMany(mappedBy = "cliente")
    private Set<Compra> compra;
}
