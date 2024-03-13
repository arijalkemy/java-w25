package com.example.bootcamp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // FORMA UNIDIRECCIONAL
    // Como no es necesario en nuestro dominio de negocio tener en cada SaleDatail un objeto Sale, solo
    // se pone JoinColum para que a la hora de pasarlo al modelo relacional le agregue el atributo ID
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "sale_id")
    private List<SaleDetails> list;
}
