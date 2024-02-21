package Ejercicio_Carrera_Selva;

public class Participante {
    private int nroParticipante;
    private int dni;
    private String nombre;
    private String apellido;
    private int edad;
    private String nroCelular;
    private String nroEmergencia;
    private String grupoSanguineo;

    public Participante(int nroParticipante, int dni, String nombre, String apellido,
                        int edad, String nroCelular, String nroEmergencia,
                        String grupoSanguineo) {
        this.nroParticipante = nroParticipante;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.nroCelular = nroCelular;
        this.nroEmergencia = nroEmergencia;
        this.grupoSanguineo = grupoSanguineo;
    }

    public int getNroParticipante() {
        return nroParticipante;
    }

    public void setNroParticipante(int nroParticipante) {
        this.nroParticipante = nroParticipante;
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

    public String getNroCelular() {
        return nroCelular;
    }

    public void setNroCelular(String nroCelular) {
        this.nroCelular = nroCelular;
    }

    public String getNroEmergencia() {
        return nroEmergencia;
    }

    public void setNroEmergencia(String nroEmergencia) {
        this.nroEmergencia = nroEmergencia;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }
}
