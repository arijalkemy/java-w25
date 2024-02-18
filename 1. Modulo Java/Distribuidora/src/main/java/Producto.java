public class Producto {
    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String toString() {
        return String.format("Producto: %s\nPrecio: %.2f", nombre, precio);
    }

    public void calcular(int cantidadDeProductos) {
        System.out.println("Resultado: " + cantidadDeProductos * this.precio);
    }
}
