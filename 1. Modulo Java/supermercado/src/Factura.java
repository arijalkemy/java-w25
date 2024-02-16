import java.util.ArrayList;
import java.util.List;
public class Factura {
    private int id;

    private Cliente cliente;

    private List<Product> products = new ArrayList<>();

    private double total;

    public Factura(int id, Cliente cliente, List<Product> products) {

        this.id = id;
        this.cliente = cliente;
        this.products = products;
        this.calcularTotal();
    }

    public void calcularTotal(){
        this.total = this.products.stream().mapToDouble( p -> p.getCosto() * p.getCantidad()).sum();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
