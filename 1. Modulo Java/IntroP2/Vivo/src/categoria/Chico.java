package src.categoria;

public class Chico extends Categoria {

    private int precioMenor;

    public Chico(int distancia, String descripcion, int precioMayor, int precioMenor) {
        super(distancia, descripcion, precioMayor);
        this.precioMenor = precioMenor;
    }

    public int getPrecioMenor() {
        return precioMenor;
    }

    public void setPrecioMenor(int precioMenor) {
        this.precioMenor = precioMenor;
    }
}
