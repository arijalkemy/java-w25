package bootcamp.siniestrosapp.model;
import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
public class Vehiculo {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private String marca;
    private String patente;
    private String modelo;
    private Integer ano;
    private Short cantidadDeRuedas;
}
