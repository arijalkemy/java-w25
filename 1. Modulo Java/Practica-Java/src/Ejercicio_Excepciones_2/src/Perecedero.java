package Ejercicio_Excepciones_2.src;

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
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        double resultado = super.calcular(cantidadDeProductos); // 20
        if(diasPorCaducar == 1){
            resultado = resultado / 4; // 20 / 4 = 5
        }
        else if (diasPorCaducar == 2){
            resultado = resultado / 3;
        }
        else if (diasPorCaducar == 3) {
            resultado = resultado / 2;
        }
        return resultado;
    }
}
