package org.example;

public class Participante {

    private Integer dni;
    private String nombre;
    private String apellido;
    private Integer edad;
    private Integer celular;
    private Integer numeroEmergencia;
    private String grupoSanguineo;

    public Participante(Integer dni, String nombre, String apellido, Integer edad, Integer celular, Integer numeroEmergencia, String grupoSanguineo) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.numeroEmergencia = numeroEmergencia;
        this.grupoSanguineo = grupoSanguineo;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
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

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getCelular() {
        return celular;
    }

    public void setCelular(Integer celular) {
        this.celular = celular;
    }

    public Integer getNumeroEmergencia() {
        return numeroEmergencia;
    }

    public void setNumeroEmergencia(Integer numeroEmergencia) {
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
        return "Datos del participante: \n" +
                "dni=" + dni +
                " nombre=" + nombre  +
                " apellido=" + apellido  +
                " edad=" + edad +
                " celular=" + celular +
                " numeroEmergencia=" + numeroEmergencia +
                " grupoSanguineo='" + grupoSanguineo ;
    }
}
