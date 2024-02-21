package Productos;

public class Perecedero extends Producto{
    int diasPorCaducar;

    @Override
    public double calcular(int cantidadProductos){
        double precioTotal = cantidadProductos * this.precio;
        int reducir = switch (this.diasPorCaducar) {
            case 1 -> 4;
            case 2 -> 3;
            case 3 -> 2;
            default -> 1;
        };
        return precioTotal / reducir;
    }

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return "Perecedero [diasPorCaducar=" + diasPorCaducar + "]";
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    

}
