package com.meli.showroom.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long numero;
    LocalDate fecha;
    Double total;
    String medioPago;
    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL)
    Set<Prenda> listPrendas;

    public Venta(Set<Prenda> listPrendas) {
        this.listPrendas = listPrendas;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((numero == null) ? 0 : numero.hashCode());
        return result;
    }
}
