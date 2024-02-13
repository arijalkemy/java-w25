package supermercado_luisina.model;

public class Item {
    private Long codigo;
    private String nombre;
    private int cantComprada;
    private double precioUnitario;

    public Item() {

    }

    public Item(Long codigo, String nombre, int cantComprada, double precioUnitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantComprada = cantComprada;
        this.precioUnitario = precioUnitario;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantComprada() {
        return cantComprada;
    }

    public void setCantComprada(int cantComprada) {
        this.cantComprada = cantComprada;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    @Override
    public String toString() {
        return "CÓDIGO: " + this.codigo + "\nNOMBRE:" + this.nombre + "\nCANT. COMPRADA: " + this.cantComprada;
    }
}
