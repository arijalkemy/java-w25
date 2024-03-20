package com.bootcamp.ejercicio_showroom.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long numero;
    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate fecha;
    Integer total;
    String medio_de_pago;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "venta_prenda",
            joinColumns = @JoinColumn(name = "id_venta"),
            inverseJoinColumns = @JoinColumn(name = "id_prenda")
    )
    List<Prenda> prendas;

    public Venta(LocalDate fecha, Integer total, String medio_de_pago, List<Prenda> prendas) {
        this.fecha = fecha;
        this.total = total;
        this.medio_de_pago = medio_de_pago;
        this.prendas = prendas;
    }
}
