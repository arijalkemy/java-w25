package org.example.concesionariaautos.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.concesionariaautos.dtos.AutomovilDto;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Automovil {

    private String marca;
    private String id;
    private String modelo;
    private String fechaCreacion;
    private String kilometraje;
    private int puertas;
    private double precio;
    private String pais;
    private Servicio servicio;
    private int cantidadDuenos;

    public Automovil(AutomovilDto auto){
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
