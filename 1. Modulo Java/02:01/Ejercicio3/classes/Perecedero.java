package classes;

public class Perecedero extends Producto {
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
    public double calcular(int cantidadDeProductos) {
        double precio = this.precio * cantidadDeProductos;
        if (this.diasPorCaducar == 1) {
            precio = this.precio * cantidadDeProductos / 4;
        } else if (this.diasPorCaducar == 2) {
            precio = this.precio * cantidadDeProductos / 3;
        } else if (this.diasPorCaducar == 3) {
            precio = this.precio * cantidadDeProductos / 2;
        }
        return precio;
    }

    @Override
    public String toString() {
        return "Perecedero [nombre=" + this.nombre + ", precio=" + this.precio + ", diasPorCaducar="
                + this.diasPorCaducar + "]";
    }

}
