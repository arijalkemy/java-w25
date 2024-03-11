package meli.com.co.joyeria_las_perlas.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Joya {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String nombre;
    @Column
    private String material;
    @Column
    private Float peso;
    @Column
    String particularidad;
    @Column(name = "posee_piedra")
    Boolean poseePiedra;
    @Column(name = "venta_o_no")
    Boolean ventaONo = true;
}
