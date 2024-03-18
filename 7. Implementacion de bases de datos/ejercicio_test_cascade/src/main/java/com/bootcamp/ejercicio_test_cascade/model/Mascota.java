package com.bootcamp.ejercicio_test_cascade.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "mascotas")
public class Mascota {

    @Id
    @Column(name = "mascota_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "propietario_id" , referencedColumnName = "id", nullable = false)
    private Propietario propietario;
    @ManyToMany(mappedBy = "mascotas", cascade = CascadeType.PERSIST)
    private Set<Vacuna> vacunas;
    public Mascota(String nombre) {
        this.nombre = nombre;
    }

    public Mascota(String nombre, Propietario propietario) {
        this.nombre = nombre;
        this.propietario = propietario;
    }
}
