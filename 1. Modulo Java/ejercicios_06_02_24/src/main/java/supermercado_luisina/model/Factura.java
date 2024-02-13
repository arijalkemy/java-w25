package supermercado_luisina.model;

import java.util.List;

public class Factura {
    private Long codigo;
    private Cliente cliente;
    private List<Item> items;
    private Double total;

    public Factura(Long codigo, Cliente cliente, List<Item> items, Double total) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.items = items;
        this.total = total;
    }

    public Factura(Long codigo, Cliente cliente, List<Item> items) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.items = items;
        this.total = calcularTotal();
    }

    public Factura() {
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
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

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "CODIGO: " + this.codigo + "\nCLIENTE:" + this.cliente.toString() + "\nITEMS:" + this.items + "\nTOTAL: " + this.total;
    }

    private Double calcularTotal() {
        Double total = 0.0;

        for (Item i : items) {
            total += i.getCantComprada() * i.getPrecioUnitario();
        }

        return total;
    }
}
