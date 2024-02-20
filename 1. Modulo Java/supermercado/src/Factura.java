import java.util.ArrayList;

public class Factura {
    private int numero;
    private Cliente cliente;
    private ArrayList<Producto> productos;

    private float total;

    public Factura(int numero, Cliente cliente, ArrayList<Producto> productos, float total) {
        this.numero = numero;
        this.cliente = cliente;
        this.productos = productos;
        this.total = total;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "numero=" + numero +
                ", cliente=" + cliente +
                ", productos=" + productos +
                ", total=" + total +
                '}';
    }
}
