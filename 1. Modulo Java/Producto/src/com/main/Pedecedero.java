package com.main;

public class Pedecedero extends Producto{
    private int diasCaducar;

    public Pedecedero(String nombre, double precio, int diasCaducar) {
        super(nombre, precio);
        this.diasCaducar = diasCaducar;
    }

    public int getDiasCaducar() {
        return diasCaducar;
    }

    public void setDiasCaducar(int diasCaducar) {
        this.diasCaducar = diasCaducar;
    }

    @Override
    public double calcular(int cantidadProducto){
        double calculo= super.calcular(cantidadProducto);
        if(diasCaducar==1){
            calculo=(calculo/4);
        }else if (diasCaducar==2){
            calculo=(calculo/3);
        }else if (diasCaducar==3) {
            calculo = (calculo / 2);
        }
        return calculo;
    }

    @Override
    public String toString() {
        return "Pedecedero{" +
                "diasCaducar=" + diasCaducar +
                '}';
    }
}
