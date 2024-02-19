package org.example.Model;

public class Participante {
    int dni;
    String nombre;
    String apellido;
    int edad;
    int celular;
    int numEmergencia;
    String rh;

    double abono;

    public Participante(int dni, String nombre, String apellido, int edad, int celular, int numEmergencia, String rh) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.numEmergencia = numEmergencia;
        this.rh = rh;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
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

    public int getNumEmergencia() {
        return numEmergencia;
    }

    public void setNumEmergencia(int numEmergencia) {
        this.numEmergencia = numEmergencia;
    }

    public String getRh() {
        return rh;
    }

    public void setRh(String rh) {
        this.rh = rh;
    }
}
