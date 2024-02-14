public class Inscripcion {
    private int numeroInscripcion;
    private Categoria categoria;
    private Participante participante;
    private double montoAPagar;

    public Inscripcion() {
    }

    public Inscripcion(int numeroInscripcion, Categoria categoria, Participante participante, double montoAPagar) {
        this.numeroInscripcion = numeroInscripcion;
        this.categoria = categoria;
        this.participante = participante;
        this.montoAPagar = montoAPagar;
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

    public double getMontoAPagar() {
        return montoAPagar;
    }

    public void setMontoAPagar(double montoAPagar) {
        this.montoAPagar = montoAPagar;
    }

    public void definirMontoAPagar(){
        switch (this.categoria.getId()){
            case 1: {
                if(participante.getEdad()<18){
                    this.montoAPagar = 1300;
                } else{
                    this.montoAPagar = 1500;
                }
            }
            break;
            case 2: {
                if(participante.getEdad()<18){
                    this.montoAPagar = 2000;
                } else{
                    this.montoAPagar = 2300;
                }
            }
            break;
            case 3: {
                if(participante.getEdad()<18){

                } else{

                }
            }
            break;
            default: this.montoAPagar = 0;
        }
    }
}
