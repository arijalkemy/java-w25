package com.example.hqlsegurosvehiculos.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Siniestro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column
    String fechaSiniestro;
    @Column
    double perdida;
    @ManyToOne
    @JoinColumn(name = "vehiculoId")
    @JsonIgnore
    Vehiculo vehiculo;
}
