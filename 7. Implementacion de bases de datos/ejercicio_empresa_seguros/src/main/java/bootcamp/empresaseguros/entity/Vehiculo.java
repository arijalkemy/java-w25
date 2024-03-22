package bootcamp.empresaseguros.entity;

import bootcamp.empresaseguros.dto.request.VehiculoRequestDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "vehiculos")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String patente;

    String marca;

    String modelo;

    Integer anioDeFabricacion;

    Integer cantidadDeRuedas;


    @OneToMany(mappedBy = "vehiculo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    List<Siniestro> siniestros;

    public Vehiculo(VehiculoRequestDTO r) {
        this.patente= r.getPatente();
        this.marca = r.getMarca();
        this.modelo = r.getModelo();
        this.anioDeFabricacion = r.getAnioDeFabricacion();
        this.cantidadDeRuedas = r.getCantidadDeRuedas();
    }

}








