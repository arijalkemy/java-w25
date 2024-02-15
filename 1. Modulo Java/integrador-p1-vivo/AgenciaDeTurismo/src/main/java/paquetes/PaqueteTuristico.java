package paquetes;
import productos.Producto;
import java.util.ArrayList;

public class PaqueteTuristico {
    private double precio;
    private ArrayList<Producto> productos;

    public PaqueteTuristico(ArrayList<Producto> productos) {
        this.productos = productos;
        this.precio = productos.stream()
                .mapToDouble(Producto::getPrecio)
                .sum();
    }

    @Override
    public String toString() {
        String str = "Precio: " + precio + "\nProductos: ";
        for (Producto prod : productos) {
            str += prod.getNombre() + ". ";
        };
        return str;
    }

    public double getPrecio() {
        return precio;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }
}
