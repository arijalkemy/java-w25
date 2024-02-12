public class Participante {
    private int numero;
    private int dni;
    private String nombre;
    private String apellido;
    private int edad;
    private String celular;
    private String numeroDeEmergencia;
    private String grupoSanguineo;

    private Inscripcion inscripcion;

    public Participante(int numero, int dni, String nombre, String apellido, int edad, String celular, String numeroDeEmergencia, String grupoSanguineo) {
        this.numero = numero;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.numeroDeEmergencia = numeroDeEmergencia;
        this.grupoSanguineo = grupoSanguineo;
    }

    public int getEdad() {
        return edad;
    }

    public void setInscripcion(Inscripcion inscripcion) {
        if (this.inscripcion != null) {
            throw new Error("El participante #" + this.numero + " ya está inscrito en una categoria");
        }
        this.inscripcion = inscripcion;
    }

    public void desinscribir() {
        this.inscripcion.anularInscripcion();
        this.inscripcion = null;
    }
}
