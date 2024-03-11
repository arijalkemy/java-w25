package joyeria.joyas.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Joya {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String nombre;
    String material;
    Double peso;
    String particularidad;
    Boolean posee_piedra;
    Boolean ventaONo;
}
