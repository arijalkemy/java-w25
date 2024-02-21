package org.example.entidades;

public class Circuito {
    private int id;
    private String nombre;
    private String descripcion;
    private int montoMenor;
    private int montoMayor;
    public Circuito (int id, String nombre, String descripcion, int montoMenor, int montoMayor) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.montoMayor = montoMayor;
        this.montoMenor = montoMenor;
    }

    public int obtenerCosto(int edad){
        return (edad > 18)? this.montoMayor : this.montoMenor;
    }

}
