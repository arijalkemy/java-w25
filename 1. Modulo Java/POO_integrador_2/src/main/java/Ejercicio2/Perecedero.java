package Ejercicio2;

public class Perecedero extends Producto{

    private int diasPorCaducar;

    public Perecedero (String nombre, double precio, int diasPorCaducar){
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }


    @Override
    public double calcular(int cantidadDeProductos){
        if (diasPorCaducar == 1){
            return (getPrecio()*cantidadDeProductos)/4;
        }
        else if (diasPorCaducar == 2) {
            return (getPrecio()*cantidadDeProductos)/3;
        }
        else if (diasPorCaducar == 3) {
            return (getPrecio()*cantidadDeProductos)/2;
        }
        return (getPrecio()*cantidadDeProductos);
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
}
