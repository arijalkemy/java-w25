public class Perecedero extends Producto {
    private int diasParaCaducar;

    public int getDiasParaCaducar() {
        return diasParaCaducar;
    }

    public void setDiasParaCaducar(int diasParaCaducar) {
        this.diasParaCaducar = diasParaCaducar;
    }

    public Perecedero(String nombre, int precio, int diasParaCaducar) {
        super(nombre, precio);
        this.diasParaCaducar = diasParaCaducar;
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "nombre='" + this.getNombre() + '\'' +
                ", precio=" + this.getPrecio() +
                "diasParaCaducar=" + this.diasParaCaducar +
                '}';
    }

    @Override
    public int calcular(int cantidadDeProductos) {
        int reducir = switch (diasParaCaducar) {
            case 1 -> 4;
            case 2 -> 3;
            case 3 -> 2;
            default -> 1;
        };
        return super.calcular(cantidadDeProductos)/reducir;
    }
}
