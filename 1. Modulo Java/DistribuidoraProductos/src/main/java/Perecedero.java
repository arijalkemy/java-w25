public class Perecedero extends Producto{

    private int diasPorCaducar;

    public Perecedero() {
    }

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
    public double calcularPrecio(int cantidadProductos) {
        return switch (diasPorCaducar) {
            case 1 -> (super.getPrecio() / 4) * cantidadProductos;
            case 2 -> (super.getPrecio() / 3) * cantidadProductos;
            case 3 -> (super.getPrecio() / 2) * cantidadProductos;
            default -> super.getPrecio() * cantidadProductos;
        };
    }
}
