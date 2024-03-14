package bootcamp.crudjpajewerly.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Jewerly {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "nro_identificatorio")
    Long nroIdentificatorio;

    String nombre;

    String material;

    Double peso;

    String particularidad;

    @Column(name = "posee_piedra")
    Boolean poseePiedra;

    Boolean ventaONo = true;

}
