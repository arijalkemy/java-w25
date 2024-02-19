public class Inscripcion {
    private int numeroInscripcion;
    private Categoria categoria;
    private Participante participante;
    private int montoAbonar;

    public Inscripcion(int numeroInscripcion, Categoria categoria, Participante participante) {
        this.numeroInscripcion = numeroInscripcion;
        this.categoria = categoria;
        this.participante = participante;
        if(this.participante.getNumInscripcion() != -1){
            System.out.println("El participante ya esta inscrito en otra carrera");
        }else{
            if(this.categoria.inscribirParticipante(this)){
                this.participante.setNumInscripcion(numeroInscripcion);
            }
        }

    }

    public int getNumeroInscripcion() {
        return numeroInscripcion;
    }

    public void setNumeroInscripcion(int numeroInscripcion) {
        this.numeroInscripcion = numeroInscripcion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public int getMontoAbonar() {
        return montoAbonar;
    }

    public void setMontoAbonar(int montoAbonar) {
        this.montoAbonar = montoAbonar;
    }

    public void eliminarInscripcion(){
        this.categoria.desinscribirParticiapnte(this);
    }
}
