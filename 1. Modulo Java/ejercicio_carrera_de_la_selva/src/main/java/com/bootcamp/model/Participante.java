package com.bootcamp.model;

public class Participante {
    private int numeroDeParticipante;
    private String dni;
    private String nombre;
    private String apellido;
    private int edad;
    private String celular;
    private String numeroDeEmergencia;
    private String grupoSanguineo;

    public Participante(int numeroDeParticipante, String dni, String nombre, String apellido, int edad, String celular, String numeroDeEmergencia, String grupoSanguineo) {
        this.numeroDeParticipante = numeroDeParticipante;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.numeroDeEmergencia = numeroDeEmergencia;
        this.grupoSanguineo = grupoSanguineo;
    }

    public int getEdad() {
        return edad;
    }
    public String getNombreYApellido(){
        return this.nombre +" " + this.apellido;
    }
    @Override
    public String toString() {
        return "Participante{" +
                "numeroDeParticipante=" + numeroDeParticipante +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", celular='" + celular + '\'' +
                ", numeroDeCelular='" + numeroDeEmergencia + '\'' +
                ", grupoSanguineo='" + grupoSanguineo + '\'' +
                '}';
    }
}
