package Controller;

import Interfaces.ICRUD;
import Models.Cliente;
import Models.Localizador;
import Models.Producto;
import Enums.ProductNames.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ClienteController {
    ICRUD<Cliente> clienteRepository;
    ICRUD<Localizador> localizadorRepository;
    ICRUD<Producto> productoRepository;

    public ClienteController(ICRUD<Cliente> clientRepository,
                             ICRUD<Localizador> localizadorRepository,
                             ICRUD<Producto> productoRepository)
    {
        this.clienteRepository = clientRepository;
        this.localizadorRepository = localizadorRepository;
        this.productoRepository = productoRepository;
    }
    public  void saveCliente(Cliente cliente){
        clienteRepository.create(cliente);

    }
    public List<Cliente> readCliente(){
        return clienteRepository.read();
    }
    public void deleteCliente(Cliente cliente){
        clienteRepository.delete(cliente);
    }
    public void updateCliente(Cliente cliente){
        clienteRepository.update(cliente);
    }

    public void CalcularDescuento(Localizador localizadorNuevo,Cliente cliente){
        int descuento = 0;
        int boletas = 0;
        int reservas = 0;
        List<Localizador> clienteLocalizador = localizadorRepository.read().stream()
                .filter(localizador -> localizador.getCliente().equals(cliente))
                .collect(Collectors.toList());
        if (clienteLocalizador.size() >= 2){
            descuento += 5;
        }
        if (isPaqueteCompleto(localizadorNuevo)){
            descuento +=10;
        }
        if(hasTwoReservasHotel(localizadorNuevo)){
            descuento += 5;
        }
        if(hasTwoBoletos(localizadorNuevo)){
            descuento += 5;
        }
    }
    private  boolean isPaqueteCompleto(Localizador localizador){
        List<EnumProductType> enumProductTypes = new ArrayList<>(Arrays.asList(EnumProductType.values()));
        List<Producto> productos = localizador.getReserva();
        productos.forEach(producto -> {
            if(enumProductTypes.contains(producto.getType())) enumProductTypes.remove(producto.getType());
        });
        return enumProductTypes.isEmpty();
    }

    private  boolean hasTwoReservasHotel(Localizador localizador){
        AtomicInteger numReservashotel= new AtomicInteger(0);
        EnumProductType[] enumProductType = EnumProductType.values();
        List<Producto> productos = localizador.getReserva();
        productos.forEach(producto -> {
            if(producto.getType().equals(EnumProductType.RESERVA_HOTEL)){
                numReservashotel.set(+1);
            };}
        );
        return numReservashotel.get() >= 2;

    }
    private  boolean hasTwoBoletos(Localizador localizador){
        AtomicInteger numBoletos= new AtomicInteger(0);
        EnumProductType[] enumProductType = EnumProductType.values();
        List<Producto> productos = localizador.getReserva();
        productos.forEach(producto -> {
            if(producto.getType().equals(EnumProductType.TICKET)){
                numBoletos.set(+1);
            };}
        );
        return numBoletos.get() >= 2;

    }



}