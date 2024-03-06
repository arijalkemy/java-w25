public class Participante {
    private int dni;
    private String nombre;
    private String apellido;
    private String celular;
    private int edad;
    private String numeroEmergencia;
    private String grupoSanguineo;

    public Participante(int dni, String nombre, String apellido, String celular, int edad, String numeroEmergencia, String grupoSanguineo) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.edad = edad;
        this.numeroEmergencia = numeroEmergencia;
        this.grupoSanguineo = grupoSanguineo;
    }

    public int getEdad() {
        return edad;
    }

    public int getDni() {
        return dni;
    }
}
