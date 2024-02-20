public class Participante {
    public int getNumeroDeParticipante() {
        return numeroDeParticipante;
    }

    @Override
    public String toString() {
        return "Participante{" +
                "\n\tnumeroDeParticipante=" + numeroDeParticipante +
                ", \n\tdni='" + dni + '\'' +
                ", \n\tnombre='" + nombre + '\'' +
                ", \n\tapellido='" + apellido + '\'' +
                ", \n\tedad=" + edad +
                ", \n\ttelefono='" + telefono + '\'' +
                ", \n\ttelefonoDeEmergencia='" + telefonoDeEmergencia + '\'' +
                ", \n\tgrupoSanguineo='" + grupoSanguineo + '\'' +
                "\n\t}";
    }

    public void setNumeroDeParticipante(int numeroDeParticipante) {
        this.numeroDeParticipante = numeroDeParticipante;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefonoDeEmergencia() {
        return telefonoDeEmergencia;
    }

    public void setTelefonoDeEmergencia(String telefonoDeEmergencia) {
        this.telefonoDeEmergencia = telefonoDeEmergencia;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    private int numeroDeParticipante;
    private String dni;
    private String nombre;
    private String apellido;
    private int edad;
    private String telefono;
    private String telefonoDeEmergencia;
    private String grupoSanguineo;

    public Participante(int numeroDeParticipante, String dni, String nombre, String apellido, int edad, String telefono, String telefonoDeEmergencia, String grupoSanguineo) {
        this.numeroDeParticipante = numeroDeParticipante;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.telefono = telefono;
        this.telefonoDeEmergencia = telefonoDeEmergencia;
        this.grupoSanguineo = grupoSanguineo;
    }
}
