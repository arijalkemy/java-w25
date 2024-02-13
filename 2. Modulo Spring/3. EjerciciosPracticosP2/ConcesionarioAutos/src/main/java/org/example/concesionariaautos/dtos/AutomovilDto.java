package org.example.concesionariaautos.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.concesionariaautos.models.Automovil;
import org.example.concesionariaautos.models.Servicio;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AutomovilDto {

    private String id;
    private String marca;
    private String modelo;
    private String fechaCreacion;
    private String kilometraje;
    private int puertas;
    private double precio;
    private String pais;
    private Servicio servicio;
    private int cantidadDuenos;

    public AutomovilDto(Automovil auto){
        this.id = auto.getId();
        this.marca = auto.getMarca();
        this.modelo = auto.getModelo();
        this.fechaCreacion = auto.getFechaCreacion();
        this.kilometraje = auto.getKilometraje();
        this.puertas = auto.getPuertas();
        this.precio = auto.getPrecio();
        this.pais = auto.getPais();
        this.servicio = auto.getServicio();
        this.cantidadDuenos = auto.getCantidadDuenos();
    }
}
