package classes;

public class Producto {
    protected String nombre;
    protected double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double calcular(int cantidadDeProductos) {
        return this.precio * cantidadDeProductos;
    }

    @Override
    public String toString() {
        return "Producto [nombre=" + this.nombre + ", precio=" + this.precio + "]";
    }

}
