package com.joyeria.Joyeria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@SQLDelete(sql = "UPDATE joya SET ventaONo = false WHERE id = ?")
@Where(clause = "ventaONo = true")
public class Joya {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    Long id;
    String nombre;
    String material;
    String particularidad;
    Double peso;
    Boolean posee_piedra;
    Boolean ventaONo;
}
