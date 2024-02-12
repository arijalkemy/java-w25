package agencia.localizador;

import agencia.cliente.Cliente;
import agencia.repository.LocalizadorRepository;
import agencia.reserva.Reserva;

import java.util.List;

public class Localizador {
    static LocalizadorRepository localizadorRepository = new LocalizadorRepository();

    private int id;
    private Cliente cliente;
    private List<Reserva> reservas;
    private double total;

    public Localizador(int id, Cliente cliente, List<Reserva> reservas, double total) {
        this.id = id;
        this.cliente = cliente;
        this.reservas = reservas;
        this.total = total;
    }


   /*
   Referencias a tipo de reserva:
    Tipo 1 = hotel
    Tipo 2 = comida
    Tipo 3 = vuelo
    Tipo 4 = transporte

    Si anteriormente adquirió al menos 2 localizadores, se le descontará un 5% del total para futuras compras.

    Si adquiere un paquete completo que consiste en reserva de hotel, comida, boletos de viajes, transporte,
     recibirá un descuento del 10% del total de la factura.

    Si adquiere 2 reservas de hotel o 2 boletos de viaje, se aplicará un descuento de 5% en esas reservas.
     */


    public double calcularDescuento() {
        double precioConDescuento = this.total;
        // verificar y aplicar descuento tipo 1

        int reservasTipo1 = 0, reservasTipo2 = 0, reservasTipo3 = 0, reservasTipo4 = 0;
        double precioTipo1 = 0, precioTipo2 = 0, precioTipo3 = 0, precioTipo4 = 0;
        for (Reserva reserva:this.reservas) {
            if (reserva.getTipo().equals("1")) {
                reservasTipo1++;
                precioTipo1 += reserva.getPrecio();
            }
            else if (reserva.getTipo().equals("2")) {
                reservasTipo2++;
                precioTipo2 += reserva.getPrecio();
            }
            else if (reserva.getTipo().equals("3")) {
                reservasTipo3++;
                precioTipo3 += reserva.getPrecio();
            }
            else if (reserva.getTipo().equals("4")) {
                reservasTipo4++;
                precioTipo4 += reserva.getPrecio();
            }
        }



        if (reservasTipo1 >= 2) {
            precioTipo1 = precioTipo1 * (.95);
        } else if(reservasTipo3 >= 2) {
            precioTipo3 = precioTipo3 * (.95);
        }

        this.total = precioTipo1 + precioTipo2 + precioTipo3 + precioTipo4;
        if (reservasTipo1 > 0 && reservasTipo2 > 0 && reservasTipo3 > 0 && reservasTipo4 > 0) {
            this.total *= .9;
        }


        if (localizadorRepository.encontrarLocalizadorByClienteId(this.cliente.getIdCliente()) >= 2){
            total *= .95;
        }

        return precioConDescuento;
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

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
