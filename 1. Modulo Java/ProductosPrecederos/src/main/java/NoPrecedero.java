public class NoPrecedero extends Producto{
    private String tipo;

    public NoPrecedero(String nombre, double precio, String tipo) {
        super(nombre, precio);
        this.tipo = tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString(){
        return "NoPrecedero{"+
                "tipo: "+tipo+
                "}";
    }
}
