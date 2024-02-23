package org.example;

import java.util.ArrayList;
import java.util.List;

public class Categoria{
    private int id;
    private String nombreCategoria;
    private int distancia;
    private String descripcion;

    public Categoria(int id, String nombreCategoria, int distancia, String descripcion/*List<Participante> listaParticipantes*/) {
        this.id = id;
        this.nombreCategoria = nombreCategoria;
        this.distancia = distancia;
        this.descripcion = descripcion;
        //this.listaParticipantes = listaParticipantes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


}
