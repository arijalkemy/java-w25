package com.example.classes;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
    private static int contador = 1;
    private int id;
    private String nombre;
    private String descripcion;
    private int distanciaKm;
    private List<Participante> participantes;
    private int valorMayor;
    private int valorMenor;
    private int totalGanancias = 0;

    public Categoria(String nombre, String descripcion, int distanciaKm, int valorMayor, int valorMenor) {
        this.id = Categoria.contador++;
        this.participantes = new ArrayList<>();
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.distanciaKm = distanciaKm;
        this.valorMayor = valorMayor;
        this.valorMenor = valorMenor;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getDistanciaKm() {
        return distanciaKm;
    }

    public void setDistanciaKm(int distanciaKm) {
        this.distanciaKm = distanciaKm;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }

    public int getValorMayor() {
        return valorMayor;
    }

    public void setValorMayor(int valorMayor) {
        this.valorMayor = valorMayor;
    }

    public int getValorMenor() {
        return valorMenor;
    }

    public void setValorMenor(int valorMenor) {
        this.valorMenor = valorMenor;
    }

    public int getTotalGanancias() {
        return totalGanancias;
    }

    public void setTotalGanancias(int totalGanancias) {
        this.totalGanancias = totalGanancias;
    }

    public void mostrarParticipantes() {
        System.out.println("Participantes de: " + this.nombre);
        for (Participante participante : this.participantes) {
            System.out.println(participante.getNombre() + " " + participante.getApellido());
        }
    }

    @Override
    public String toString() {
        return "Inscripcion [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", distanciaKm="
                + distanciaKm + ", participantes=" + participantes + "]";
    }
}
