package Ejercicio2;

public class Perecedero extends Product {

    private int diasPorCaducar;

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    //Constructor
    public Perecedero(String name, double price, int diasPorCaducar) {
        super(name, price);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return "Peresedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    @Override
    public double calcular(int cantidadProductos){

        double monto = super.calcular(cantidadProductos);

       return switch (this.diasPorCaducar) {
            case 1 -> monto / 4;
            case 2 -> monto / 3;
            case 3 -> monto / 2;
            default -> monto;
        };



    }




}
