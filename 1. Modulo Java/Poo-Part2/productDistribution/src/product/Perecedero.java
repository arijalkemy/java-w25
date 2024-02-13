package product;

public class Perecedero extends Producto{

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
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        double superResult =  super.calcular(cantidadDeProductos);
        switch (diasPorCaducar){
            case 1 -> {
                return superResult/4;
            }
            case 2 -> {
                return superResult/3;
            }
            case 3 -> {
                return superResult/2;
            }
            default -> {
                return superResult;
            }
        }
    }
}
