package com.main;

import com.main.Clases.Cliente;
import com.main.Clases.LocalizadorReservas;
import com.main.Clases.RepositorioReservas;
import com.main.Servicios.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static double descuentos(List<Reservas> seleccionServ,Cliente cliente,List<LocalizadorReservas> listLocalizadores){
        double totalServicios = seleccionServ.stream().mapToDouble(Reservas::totalReserva).sum();
        //System.out.println(totalServicios);
        long countCliente= listLocalizadores.stream()
                .filter(x -> x.getCliente().getNombre().equals(cliente.getNombre()))
                .count();
        //System.out.println(countCliente);
        boolean hayComida = seleccionServ.stream().anyMatch(reserva -> reserva instanceof Comida);
        boolean hayHotel = seleccionServ.stream().anyMatch(reserva -> reserva instanceof Hotel);
        boolean hayBoletos = seleccionServ.stream().anyMatch(reserva -> reserva instanceof BoletosViaje);
        boolean hayTrasporte = seleccionServ.stream().anyMatch(reserva -> reserva instanceof Transporte);

        if (countCliente>2){
            //Descuento del 10% si tiene los 4 servicios
            if(hayComida && hayHotel && hayBoletos && hayTrasporte){
                double porcDecuento= totalServicios*0.15;
                double totalFinal=totalServicios-porcDecuento;
                return totalFinal;
            }
            //Descuento del 5% si tiene dos reservas por hotel y boletos
            if(hayHotel && hayBoletos){
                List<Double> cantHotel= seleccionServ.stream()
                        .filter(servicio -> servicio instanceof Hotel)
                        .map(servicio -> servicio.getCantidad())
                        .collect(Collectors.toList());
                List<Double> cantBoletos= seleccionServ.stream()
                        .filter(servicio -> servicio instanceof BoletosViaje)
                        .map(servicio -> servicio.getCantidad())
                        .collect(Collectors.toList());
                if ((cantHotel.get(0) == 2f)&&(cantBoletos.get(0) == 2f)){
                    double porcDecuento= totalServicios*0.1;
                    double totalFinal=totalServicios-porcDecuento;
                    return totalFinal;
                }
            }
        }
        //Descuento del 10% si tiene los 4 servicios
        if(hayComida && hayHotel && hayBoletos && hayTrasporte){
            double porcDecuento= totalServicios*0.1;
            double totalFinal=totalServicios-porcDecuento;
            return totalFinal;
        }
        //Descuento del 5% si tiene dos reservas por hotel y boletos
        if(hayHotel && hayBoletos){
            List<Double> cantHotel= seleccionServ.stream()
                    .filter(servicio -> servicio instanceof Hotel)
                    .map(servicio -> servicio.getCantidad())
                    .collect(Collectors.toList());
            List<Double> cantBoletos= seleccionServ.stream()
                    .filter(servicio -> servicio instanceof BoletosViaje)
                    .map(servicio -> servicio.getCantidad())
                    .collect(Collectors.toList());
            if ((cantHotel.get(0) == 2f)&&(cantBoletos.get(0) == 2f)){
                double porcDecuento= totalServicios*0.05;
                double totalFinal=totalServicios-porcDecuento;
                return totalFinal;
            }
        }
        return totalServicios;

    }

    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Julieta","Fernandez","12345");
        Cliente cliente2 = new Cliente("Mauricio","Lopez","54321");

        //Lista de Localizadores para el Repositorio
        List<LocalizadorReservas> listLocalizadores= new ArrayList<>();


        //RESERVA 1 = paquete completo de cliente1
        System.out.println("--- RESERVA DE PAQUETE COMPLETO ---");
        List<Reservas> servicios1= new ArrayList<>();
        servicios1.add(new Comida(30000,1f));
        servicios1.add(new Hotel(20000,2f));
        servicios1.add(new Transporte(10000,1f));
        servicios1.add(new BoletosViaje(30000,1f));
        //servicios1.forEach(x -> x.realizarReserva());

        double totalPagar1 = descuentos(servicios1,cliente1,listLocalizadores);
        LocalizadorReservas reserva1 = new LocalizadorReservas(cliente1,totalPagar1,servicios1);
        listLocalizadores.add(reserva1);
        RepositorioReservas repLocalizador1 = new RepositorioReservas(reserva1);
        System.out.println(repLocalizador1);



        //RESERVA 2 = 2 hotel 2 boleto viaje de cliente2
        System.out.println("--- DOS RESERVAS DE HOTEL Y BOLETOS ---");
        List<Reservas> servicios2= new ArrayList<>();
        servicios2.add(new Hotel(20000,2f));
        servicios2.add(new BoletosViaje(30000,2f));
        //servicios2.forEach(x -> x.realizarReserva());

        double totalPagar2 = descuentos(servicios2,cliente2,listLocalizadores);
        LocalizadorReservas reserva2 = new LocalizadorReservas(cliente2,totalPagar2,servicios2);
        listLocalizadores.add(reserva2);
        RepositorioReservas repLocalizador2 = new RepositorioReservas(reserva2);
        System.out.println(repLocalizador2);



        //OTRA RESERVAS DEL CLIENTE2
        List<Reservas> servicios3= new ArrayList<>();
        servicios3.add(new Comida(30000,1f));
        servicios3.add(new Transporte(10000,1f));

        double totalPagar3 = descuentos(servicios3,cliente2,listLocalizadores);
        LocalizadorReservas reserva3 = new LocalizadorReservas(cliente2,totalPagar3,servicios3);
        listLocalizadores.add(reserva3);
        RepositorioReservas repLocalizador3 = new RepositorioReservas(reserva3);
        System.out.println(repLocalizador3);

        List<Reservas> servicios4= new ArrayList<>();
        servicios4.add(new Comida(30000,1f));
        servicios4.add(new Transporte(10000,1f));
        servicios4.add(new Hotel(20000,2f));

        double totalPagar4 = descuentos(servicios4,cliente2,listLocalizadores);
        LocalizadorReservas reserva4 = new LocalizadorReservas(cliente2,totalPagar4,servicios4);
        listLocalizadores.add(reserva4);
        RepositorioReservas repLocalizador4 = new RepositorioReservas(reserva4);
        System.out.println(repLocalizador4);

        double totalPagar5 = descuentos(servicios2,cliente2,listLocalizadores);
        LocalizadorReservas reserva5 = new LocalizadorReservas(cliente2,totalPagar5,servicios2);
        listLocalizadores.add(reserva5);
        RepositorioReservas repLocalizador5 = new RepositorioReservas(reserva5);
        System.out.println(repLocalizador5);


    }


}
