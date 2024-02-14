
public class Precedero extends Producto {
    private int diasPorCaducar;

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public Precedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString(){
        return "Precedero{"+
                "diasPorCaducar: "+diasPorCaducar+
                "}";
    }

    @Override
    public double calcular(int cantProductos){
        double resultado = super.calcular(cantProductos);
        if(diasPorCaducar==1){
            resultado = resultado/4;
        } else if (diasPorCaducar==2) {
            resultado = resultado/3;
        } else if (diasPorCaducar==3) {
            resultado = resultado/2;
        }
        return resultado;
    }
}
