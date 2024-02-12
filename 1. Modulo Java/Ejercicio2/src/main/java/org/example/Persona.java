package org.example;

public class Persona {
    int numeroParticipante;
    int edad;
    int dni;
    String nombre;
    String apellido;
    int celular;
    int numeroEmergencia;
    String grupoSanguineo;

    public Persona(int numeroParticipante, int edad, int dni, String nombre, String apellido, int celular, int numeroEmergencia, String grupoSanguineo) {
        this.numeroParticipante = numeroParticipante;
        this.edad = edad;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.numeroEmergencia = numeroEmergencia;
        this.grupoSanguineo = grupoSanguineo;
    }
}
