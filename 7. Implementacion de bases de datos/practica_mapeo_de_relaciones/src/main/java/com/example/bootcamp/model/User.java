package com.example.bootcamp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL) // Relacion uno a uno con adress
    // CascadeType: ALL
    // Se ejecutarán todas las operaciones en cascada
    // Se indica el tipo de propagación que usaremos en la base de datos
    @JoinColumn(name = "id_address", referencedColumnName = "id") // Define el nombre de la columna a la que hace referencia
    // Se escoge la entidad q tenga mayor peso sobre otra para poner la columna de ID
    private Address address;
}



