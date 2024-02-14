package org.example;

public class Persona {


    private String apellido;
    private int edad;

    public Persona(String apellido, int edad) {
        this.apellido = apellido;
        this.edad = edad;
    }

    public void mostrarApellido(){

        System.out.println("El appellido es " + apellido);
    }

}
