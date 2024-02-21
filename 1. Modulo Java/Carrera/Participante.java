package Carrera;

public class Participante {
    int id;
    String cedula;
    String nombre;
    int edad;
    String celular;
    String numeroEmergencia;
    String rh;

    public Participante(int id, String cedula, String nombre, int edad, String celular, String numeroEmergencia,
            String rh) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.edad = edad;
        this.celular = celular;
        this.numeroEmergencia = numeroEmergencia;
        this.rh = rh;
    }

    public int getId() {
        return id;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getCelular() {
        return celular;
    }

    public String getNumeroEmergencia() {
        return numeroEmergencia;
    }

    public String getRh() {
        return rh;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setNumeroEmergencia(String numeroEmergencia) {
        this.numeroEmergencia = numeroEmergencia;
    }

    public void setRh(String rh) {
        this.rh = rh;
    }     
    
}
