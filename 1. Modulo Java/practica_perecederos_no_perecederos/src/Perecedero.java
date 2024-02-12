public class Perecedero extends Producto {

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
    public double calcular(int cantidadDeProductos){
        double precioFinal = super.calcular(cantidadDeProductos);

        return switch (diasPorCaducar){
            case 1 -> precioFinal -= 4*precioFinal;
            case 2 -> precioFinal -= 3*precioFinal;
            case 3 -> precioFinal -= 2*precioFinal;
            default -> precioFinal;
        };
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }
}
