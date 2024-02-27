package POOP2VIVO.Ejercicio2;

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
    public double calcular(int cantidadDeProductos){
        double calculoParcial = super.calcular(cantidadDeProductos);
        switch (this.diasPorCaducar){
            case 1:{return  calculoParcial/4;}
            case 2:{ return calculoParcial/3;}
            case 3:{return calculoParcial/2;}
            default:{return  calculoParcial;}
        }


    }
}
