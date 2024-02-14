package bootcamp.domain;

public class Perecedero extends Producto {

    private int diasPorCaducar;

    public Perecedero(String nombre, Double precio, int diasPorCaducar) {
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
    public double calcular(int cantidadDeProductos) {
        switch (diasPorCaducar) {
            case 1:
                return precio * cantidadDeProductos / 4;
            case 2:
                return precio * cantidadDeProductos / 3;
            case 3:
                return precio * cantidadDeProductos / 2;
            default:
                return precio * cantidadDeProductos;
        }
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
