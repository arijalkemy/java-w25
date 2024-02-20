package org.example;

public class Perecedero extends Producto{
    private int diasPorCaducar;

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    @Override
    public double calcular(int cantidadDeProductos){
        if( diasPorCaducar == 1){
            return (cantidadDeProductos * getPrecio())/4;
        }

        if( diasPorCaducar == 2 ){
            return (cantidadDeProductos * getPrecio())/3;
        }

        if( diasPorCaducar == 3){
            return (cantidadDeProductos * getPrecio())/2;
        }

        return cantidadDeProductos * getPrecio();
    }

}
