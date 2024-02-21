package Ejercicio_Carrera_Selva;

public class Inscripcion {
    private int nroInscripcion;
    private String categoria;
    private Participante participante;
    private double montoAbonar;

    public Inscripcion(int nroInscripcion, String categoria, Participante participante) throws Exception {
        this.nroInscripcion = nroInscripcion;
        this.categoria = categoria;
        this.participante = participante;
    }

    public void calcularMonto() throws Exception {
        if (this.categoria.equalsIgnoreCase("Chico")) {
            if(this.participante.getEdad() < 18) {
                this.montoAbonar = 1300;
            } else {
                this.montoAbonar = 1500;
            }
        } else if (this.categoria.equalsIgnoreCase("Medio")) {
            if(this.participante.getEdad() < 18) {
                this.montoAbonar = 2000;
            } else {
                this.montoAbonar = 2300;
            }
        } else if (this.categoria.equalsIgnoreCase("Avanzado")) {
            if(this.participante.getEdad() >= 18) {
                this.montoAbonar = 2800;
            } else {
                throw new Exception("No se permite la inscripcion a menores de 18 años.");
            }
        }
    }

    public int getNroInscripcion() {
        return nroInscripcion;
    }

    public void setNroInscripcion(int nroInscripcion) {
        this.nroInscripcion = nroInscripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public double getMontoAbonar() {
        return montoAbonar;
    }

    public void setMontoAbonar(double montoAbonar) {
        this.montoAbonar = montoAbonar;
    }

    @Override
    public String toString() {
        return "Nro Inscripcion: " + nroInscripcion +
                ", categoria: '" + categoria + '\'' +
                ", monto a abonar: " + montoAbonar;
    }
}
