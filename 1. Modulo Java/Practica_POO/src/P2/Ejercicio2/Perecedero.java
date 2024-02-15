package P2.Ejercicio2;

public class Perecedero extends Producto{
    private int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public double calcular(int cantidad) {
        double precio =  super.calcular(cantidad);
        switch (diasPorCaducar){
            case 1 -> precio = precio/4;
            case 2 -> precio = precio/3;
            case 3 -> precio = precio/2;
        }
        return precio;
    }

    @Override
    public String toString() {
        return super.toString() + "\nPerecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }
}
