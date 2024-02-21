package Carrera;

public class Inscripcion {
    int id;
    String Categoria;
    Participante participante;
    private double montoAbonar;
    
    public Inscripcion(int id, String categoria, Participante participante) {
        this.id = id;
        Categoria = categoria;
        this.participante = participante;
        inscripcionParticipante();
    }

    private void inscripcionParticipante(){
        CircuitoGenerado circuitoGenerado = new CircuitoGenerado(getCategoria(), participante.getEdad());
        this.montoAbonar = circuitoGenerado.getValor();
    }

    public int getId() {
        return id;
    }

    public String getCategoria() {
        return Categoria;
    }

    public Participante getParticipante() {
        return participante;
    }

    public double getMontoAbonar() {
        return montoAbonar;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public void setMontoAbonar(double montoAbonar) {
        this.montoAbonar = montoAbonar;
    }

    

}
