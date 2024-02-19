import java.util.List;

public class Factura {
    private Cliente cliente;
    private List<Item> items;
    private double montoTotal;

    public Factura(Cliente cliente, List<Item> items) {
        this.cliente = cliente;
        this.items = items;
        this.calcularMonto();
    }

    private void calcularMonto(){
        this.montoTotal = this.items.stream().mapToDouble(Item::getCostoUnitario);
    }
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }
}
