package Clases;

import java.util.List;

public class Localizador {

    private Cliente cliente;
    private double total;
    private double totalConDescuento;
    private List<Paquete> listaPaquete;

    public Localizador(Cliente cliente, List<Paquete> listaPaquete) {
        this.cliente = cliente;
        this.listaPaquete=listaPaquete;
        this.total = calcularTotal();

    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    public double getTotalConDescuento() {
        return totalConDescuento;
    }

    public void setTotalConDescuento(double totalConDescuento) {
        this.totalConDescuento = totalConDescuento;
    }

    public List<Paquete> getListaPaquete() {
        return  listaPaquete;
    }

    public void setListaPaquete(List<Paquete> listaPaquete) {
        this.listaPaquete = listaPaquete;
    }

    @Override
    public String toString() {
        return "Localizador {" +
                "cliente = '" + cliente + '\'' +
                ", total = " + total + '\'' +
                ", total = " +totalConDescuento+ '\'' +
                ", listaPaquete = " + listaPaquete +
                '}';
    }

    public void addPaquete(Paquete paquete){
        this.listaPaquete.add(paquete);
    }
    public double calcularTotal(){

        return this.listaPaquete.stream().mapToDouble(Paquete::getCosto).sum();
    }
}
