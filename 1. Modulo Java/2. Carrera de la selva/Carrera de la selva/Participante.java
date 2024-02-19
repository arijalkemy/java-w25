public class Participante {
        private int numInscripcion;
        private int identificacion;
        private String nombre;
        private String apellido;
        private int edad;
        private long celular;
        private long numeroEmergencia;
        private String grupoSanguineo;

    public Participante(int identificacion, String nombre, String apellido, int edad, long celular, long numeroEmergencia, String grupoSanguineo) {
        this.numInscripcion = -1;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.numeroEmergencia = numeroEmergencia;
        this.grupoSanguineo = grupoSanguineo;
    }

    public int getNumInscripcion() {
        return numInscripcion;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public long getCelular() {
        return celular;
    }

    public long getNumeroEmergencia() {
        return numeroEmergencia;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setNumInscripcion(int numParticipante) {
        this.numInscripcion = numParticipante;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setCelular(long celular) {
        this.celular = celular;
    }

    public void setNumeroEmergencia(long numeroEmergencia) {
        this.numeroEmergencia = numeroEmergencia;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    @Override
    public String toString() {
        return "Participante{" +
                "numParticipante=" + numInscripcion +
                ", identificacion=" + identificacion +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", celular=" + celular +
                ", numeroEmergencia=" + numeroEmergencia +
                ", grupoSanguineo='" + grupoSanguineo + '\'' +
                '}';
    }
}
