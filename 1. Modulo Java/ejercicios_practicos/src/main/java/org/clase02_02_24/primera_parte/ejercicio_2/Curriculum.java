package org.clase02_02_24.primera_parte.ejercicio_2;

public class Curriculum implements Imprimible<Curriculum>{
    String nombre;
    String apellido;

    @Override
    public String toString() {
        return "Curriculum{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }

    public Curriculum(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Override
    public void imprimir() {
        System.out.println("Se esta imprimiendo el curriculum: " + this);
    }
}
