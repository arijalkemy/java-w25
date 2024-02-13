package org.example.models;

public class Participante {

    public enum GrupoSanguineo{
        A,B,AB,O
    }
    private int numero;
    private int dni;
    private String nombre;
    private String apellido;
    private int edad;
    private String celular;
    private String numeroEmergencia;
    private GrupoSanguineo grupoSanguineo;

    public Participante(int numero, int dni, String nombre, String apellido, int edad, String celular, String numeroEmergencia, GrupoSanguineo grupoSanquineo){
        this.numero = numero;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.numeroEmergencia = numeroEmergencia;
        this.grupoSanguineo = grupoSanquineo;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return "Participante{" +
                "numero=" + numero +
                ", dni=" + dni +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", celular='" + celular + '\'' +
                ", numeroEmergencia='" + numeroEmergencia + '\'' +
                ", grupoSanguineo=" + grupoSanguineo +
                '}';
    }
}
