package org.example;

public class Perecedero extends Producto{
    private int diasPorCaducar ;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public double calcular(int cantidad){
        double resultado = super.calcular(cantidad);
        return switch(this.diasPorCaducar) {
            case 1 -> resultado/4;
            case 2 -> resultado/3;
            case 3 -> resultado/2;
            default -> resultado;
        };
    }

    @Override
    public String toString() {
        return super.toString() +
                "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }
}
