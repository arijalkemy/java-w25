package model;

public class Inscripcion {
    private int numero;
    private Categoria categoria;
    private Participante participante;
    private double monto;

    public Inscripcion(int numero, Categoria categoria, Participante participante) {
        this.numero = numero;
        this.categoria = categoria;
        this.participante = participante;
        this.monto = calcularMonto();
    }

    public double calcularMonto(){

        int categoria = this.categoria.getId();
        int edad = this.participante.getEdad();
        double monto;

        if (categoria == 1){
            if (edad < 18)
                monto = 1300;
            else
                monto = 1500;
        } else if (categoria == 2) {
            if (edad < 18)
                monto = 2000;
            else
                monto = 2300;
        } else {
            if (edad < 18)
                throw new IllegalArgumentException("No se permiten inscripciones a menores de 18 años en el Circuito Avanzado.");
            else
                monto = 2800;
        }
        return monto;
    }
    @Override
    public String toString() {
        return "Inscripcion{" +
                "numero=" + numero +
                ", categoria=" + categoria +
                ", participante=" + participante +
                ", monto=" + monto +
                '}';
    }

    public Categoria getCategoria() {
        return categoria;
    }
}
