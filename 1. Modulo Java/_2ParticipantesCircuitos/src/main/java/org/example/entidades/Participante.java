package org.example.entidades;

public class Participante {
    private int numeroPart;
    private String dni;
    private String nombre;
    private String apellido;
    private int edad;
    private String celular;
    private String numeroEmergencia;
    private String grupoSanguineo;

    public Participante(int numeroPart, String dni, String nombre, String apellido, int edad, String celular, String numeroEmergencia, String grupoSangineo){
        this.numeroPart = numeroPart;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.numeroEmergencia = numeroEmergencia;
        this.grupoSanguineo = grupoSangineo;
    }

    public int getEdad() {
        return this.edad;
    }

    public String toString(){
        return "NumeroParticipante: " + numeroPart
                + " Dni: " + dni
                + " Nombre: " + nombre + apellido
                + "Edad: " + edad
                + " Celular" + celular
                + " Numero de Emergencia: " + numeroEmergencia
                + " Grupo Sanguineo: " + grupoSanguineo;
    }
}
