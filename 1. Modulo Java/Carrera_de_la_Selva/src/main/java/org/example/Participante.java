package org.example;
public class Participante {
    private Integer numeroParticipante;
    private String dni;
    private String apellido;
    private String nombre;
    private int edad;
    private String celular;
    private String celularEmergencia;
    private String grupoSanguineo;


    public Participante(Integer numeroParticipante, String dni, String apellido, String nombre, int edad, String celular, String celularEmergencia, String grupoSanguineo) {
        this.numeroParticipante = numeroParticipante;
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.edad = edad;
        this.celular = celular;
        this.celularEmergencia = celularEmergencia;
        this.grupoSanguineo = grupoSanguineo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Integer getNumeroParticipante() {
        return numeroParticipante;
    }

    public void setNumeroParticipante(Integer numeroParticipante) {
        this.numeroParticipante = numeroParticipante;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCelularEmergencia() {
        return celularEmergencia;
    }

    public void setCelularEmergencia(String celularEmergencia) {
        this.celularEmergencia = celularEmergencia;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    @Override
    public String toString() {
        return "Participante{" +
                "numeroParticipante=" + numeroParticipante +
                ", dni='" + dni + '\'' +
                ", apellido='" + apellido + '\'' +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", celular='" + celular + '\'' +
                ", celularEmergencia='" + celularEmergencia + '\'' +
                ", grupoSanguineo='" + grupoSanguineo + '\'' +
                '}';
    }
}
