package com.example.classes;

public class Participante {
    private static int contador = 1;
    private int numero;
    private String nombre;
    private String apellido;
    private int edad;
    private int celular;
    private int numeroEmergencia;
    private String grupoSanguineo;

    public Participante(String nombre, String apellido, int edad, int celular, int numeroEmergencia,
            String grupoSanguineo) {
        this.numero = Participante.contador++;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.numeroEmergencia = numeroEmergencia;
        this.grupoSanguineo = grupoSanguineo;
    }

    public int getNumero() {
        return numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public int getNumeroEmergencia() {
        return numeroEmergencia;
    }

    public void setNumeroEmergencia(int numeroEmergencia) {
        this.numeroEmergencia = numeroEmergencia;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    @Override
    public String toString() {
        return "Participante [numero=" + numero + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad
                + ", celular=" + celular + ", numeroEmergencia=" + numeroEmergencia + ", grupoSanguineo="
                + grupoSanguineo + "]";
    }

}
