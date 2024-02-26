package org.example;

public class Perecedero extends Producto{
    private int diasPorCaducar;

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
    public String toString() {
        return super.toString() + "diasPorCaducar=" + diasPorCaducar + '\n';
    }

    @Override
    public double calcular(int cant){
        if (this.diasPorCaducar == 1){
            return this.precio * cant * 0.25;
        } else if(this.diasPorCaducar == 2){
            return this.precio * cant * 0.33;
        } else if(this.diasPorCaducar == 3){
            return this.precio * cant * 0.5;
        } else{
            return super.calcular(cant);
        }
    }
}
