package org.example.concesionariaautos.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.concesionariaautos.models.Automovil;
import org.example.concesionariaautos.models.Servicio;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AutomovilNoServicesDto {

    private String marca;
    private String modelo;
    private String fechaCreacion;
    private String kilometraje;
    private int puertas;
    private double precio;
    private String pais;
    private int cantidadDuenos;

    public AutomovilNoServicesDto(Automovil auto){
        this.marca = auto.getMarca();
        this.modelo = auto.getModelo();
        this.fechaCreacion = auto.getFechaCreacion();
        this.kilometraje = auto.getKilometraje();
        this.puertas = auto.getPuertas();
        this.precio = auto.getPrecio();
        this.pais = auto.getPais();
        this.cantidadDuenos = auto.getCantidadDuenos();
    }
}
