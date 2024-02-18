import java.util.List;
import java.util.ArrayList;

public class Distribuidora {
    private List<Producto> productos;

    public Distribuidora() {
        this.productos =  new ArrayList<>();
    }

    public List<Producto> getProductos() {
        return this.productos;
    }

    public void agregarProducto(Producto prod) {
        this.productos.add(prod);
    }

    public void calcularPrecioTotal() {
        int total = 0;
        for (Producto p : productos) {
            total += p.getPrecio();
        }
        System.out.println("El precio total es " + total);
    }
}
