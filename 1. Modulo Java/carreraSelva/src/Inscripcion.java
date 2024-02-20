public class Inscripcion {

    private Integer numInscripcion;
    private Circuito categoria;
    private Participante participante;
    private Integer montoAAbonar;

    public Inscripcion(Integer numInscripcion, Circuito categoria, Participante participante, Integer montoAAbonar) {
        this.numInscripcion = numInscripcion;
        this.categoria = categoria;
        this.participante = participante;
        this.montoAAbonar = montoAAbonar;
    }

    @Override
    public String toString() {
        return "Inscripcion{" +
                "\n\tnumInscripcion=" + numInscripcion +
                ", \n\tcategoria=" + categoria.getNombre() +
                ", \n\tparticipante=\n\t" + participante.toString() +
                ", \n\tmontoAAbonar=" + montoAAbonar +
                '}';
    }

    public Integer getNumInscripcion() {
        return numInscripcion;
    }

    public void setNumInscripcion(Integer numInscripcion) {
        this.numInscripcion = numInscripcion;
    }

    public Circuito getCategoria() {
        return categoria;
    }

    public void setCategoria(Circuito categoria) {
        this.categoria = categoria;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public Integer getMontoAAbonar() {
        return montoAAbonar;
    }

    public void setMontoAAbonar(Integer montoAAbonar) {
        this.montoAAbonar = montoAAbonar;
    }
}
