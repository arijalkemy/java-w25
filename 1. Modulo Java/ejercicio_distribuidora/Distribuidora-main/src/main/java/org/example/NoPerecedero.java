package org.example;

public class NoPerecedero extends Producto {
    String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public NoPerecedero(String nombre, double precio, String tipo){
        super(nombre,precio);
        this.tipo =tipo;
    }

    @Override
    public String toString(){
        return "No Perecedero.  Nombre: "+ this.getNombre() + ", Precio: " + this.getPrecio() + ", Tipo: "+this.tipo;
    }
}
