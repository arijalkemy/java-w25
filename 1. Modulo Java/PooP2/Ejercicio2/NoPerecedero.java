package Ejercicio2;

public class NoPerecedero extends Product{

    private String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    //Constructor
    public NoPerecedero(String name, double price, String tipo) {
        super(name, price);
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "NoPerecedero{" +
                "tipo='" + tipo + '\'' +
                '}';
    }

    @Override
    public double calcular(int cantidadProductos) {
        return super.calcular(cantidadProductos);

    }



}
