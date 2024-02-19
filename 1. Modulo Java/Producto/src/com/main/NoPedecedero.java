package com.main;

public class NoPedecedero extends Producto{
    private String tipo;

    public NoPedecedero(String nombre, double precio, String tipo) {
        super(nombre, precio);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public double calcular(int cantidadProducto){
        double calculo= super.calcular(cantidadProducto);
        return calculo;
    }

    @Override
    public String toString() {
        return "NoPedecedero{" +
                "tipo='" + tipo + '\'' +
                '}';
    }
}
