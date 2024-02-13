package model;

public class Participante {
    private String dni, apellido, nombre, grupoSanguineo, celular, celularEmergencia;
    private int edad, numero;

    public Participante(String dni, String apellido, String nombre, String grupoSanguineo, String celular, String celularEmergencia, int edad, int num) {
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.grupoSanguineo = grupoSanguineo;
        this.celular = celular;
        this.celularEmergencia = celularEmergencia;
        this.edad = edad;
        this.numero = num;
    }

    public int getNum() {
        return numero;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return "Participante{" +
                "dni='" + dni + '\'' +
                ", apellido='" + apellido + '\'' +
                ", nombre='" + nombre + '\'' +
                ", grupoSanguineo='" + grupoSanguineo + '\'' +
                ", celular='" + celular + '\'' +
                ", celularEmergencia='" + celularEmergencia + '\'' +
                ", edad=" + edad +
                ", numero=" + numero +
                '}';
    }
}
