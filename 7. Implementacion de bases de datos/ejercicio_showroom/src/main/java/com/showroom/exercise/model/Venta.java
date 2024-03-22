package com.showroom.exercise.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "ventas")
@Table(name = "ventas")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long numero;
    LocalDate fecha;
    Double total;
    @Column(name = "medio_pago")
    String medioPago;
    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL)
    Set<Prenda> prendas;

    public Venta(Set<Prenda> prendas){
        this.prendas=prendas;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((numero == null) ? 0 : numero.hashCode());
        return result;
    }
}
