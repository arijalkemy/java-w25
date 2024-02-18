public class Participante {
    int numParticipante;
    int dni;
    String nombre;
    String apellido;
    int edad;
    int celular;
    int numEmergencia;
    String grupoSanguineo;

    public Participante(int numParticipante, int dni, String nombre, String apellido, int edad, int celular, int numEmergencia, String grupoSanguineo) {
        this.numParticipante = numParticipante;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.numEmergencia = numEmergencia;
        this.grupoSanguineo = grupoSanguineo;
    }
}
