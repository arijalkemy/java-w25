package com.bootcamp.ejercicio_test_cascade.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vacuna {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    String nombre;
    Integer dosis;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "vacuna_mascota",
            joinColumns = @JoinColumn(name = "vacuna_id"),
            inverseJoinColumns = @JoinColumn(name = "mascota_id")
    )
    private Set<Mascota> mascotas;

    public Vacuna( String nombre, Integer dosis, Set<Mascota> mascotas) {

        this.nombre = nombre;
        this.dosis = dosis;
        this.mascotas = mascotas;
    }
}
