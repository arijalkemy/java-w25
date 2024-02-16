package Models;

import java.util.ArrayList;
import java.util.Date;

public class Localizador {
    private int id;

    private Date fecha;
    private ArrayList<Producto> reserva;
    private  double total;

    private Cliente cliente;


    public Localizador() {
    }

    public Localizador(int id, Date fecha, ArrayList<Producto> productos, Cliente cliente) {
        this.id = id;
        this.fecha = fecha;
        this.reserva = productos;
        this.total = productos.stream().mapToDouble(Producto::getPrecio).sum();
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public ArrayList<Producto> getReserva() {
        return reserva;
    }

    public void setReserva(ArrayList<Producto> reserva) {
        this.reserva = reserva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
