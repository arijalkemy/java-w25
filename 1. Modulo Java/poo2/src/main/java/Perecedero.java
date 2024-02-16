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
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    @Override
    public void calcular(int cantidadDeProductos) {
        int resultado = (int) (cantidadDeProductos * this.getPrecio());

        switch (diasPorCaducar) {
            case 1:
                resultado = resultado / 4;
                break;
            case 2:
                resultado = resultado / 3;
                break;
            case 3:
                resultado = resultado / 2;
                break;
        }
        System.out.println("Resultado: " + resultado);
    }
}
