package src.main.java.org.example;

public class Perecedero extends Producto{
    int diasPorCaducar;

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
        double PrecioCalcular = super.calcular(cantidadDeProductos);

        if (diasPorCaducar == 1){
            return PrecioCalcular/4;
        }
        else {
            if (diasPorCaducar == 2){
                return PrecioCalcular/3;
            }
            else {
                return PrecioCalcular/2;
            }
        }
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }


}
